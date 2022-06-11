package ast;

import utils.*;

import java.util.ArrayList;

public class FunctionNode implements Node {
    private final TypeNode type;
    private final String id;
    private final ArrayList<Node> declarations;
    private final ArrayList<Node> assets;
    private final ArrayList<Node> fields;
    private final ArrayList<Node> statements;
    private final ArrayList<STEntry> assetEntries = new ArrayList<>();
    private ArrayList<Node> globalAssets;
    private boolean isRecursive = false;

    public FunctionNode(TypeNode type, String id, ArrayList<Node> declarations, ArrayList<Node> assets, ArrayList<Node> fields, ArrayList<Node> statements) {
        this.type = type;
        this.id = id;
        this.declarations = declarations;
        this.assets = assets;
        this.fields = fields;
        this.statements = statements;
    }

    public void setGlobalAssets(ArrayList<Node> globalAssets) {
        this.globalAssets = globalAssets;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> errors = new ArrayList<>();
        if (env.isDeclaredInScope(id)) {
            errors.add(SemanticError.duplicateDeclaration(id));
            return errors;
        }

        ArrayList<TypeNode> types = new ArrayList<>();
        for (Node declaration : declarations) {
            types.add(((ParamNode) declaration).getType());
        }
        for (int i = 0; i < assets.size(); i++) {
            types.add(TypeNode.ASSET);
        }

        types.add(type);

        env.addEntry(id, new STEntry(env.getNestLevel(), types, env.offset--));

        env.enterScope();
        int parOffset = 1;
        for (Node d : declarations) {
            errors.addAll(d.checkSemantics(env));
            env.addEntry(((ParamNode) d).getId(), new STEntry(env.getNestLevel(), ((ParamNode) d).getType(), parOffset++));
        }
        for (Node a : assets) {
            errors.addAll(a.checkSemantics(env));
            STEntry entry = new STEntry(env.getNestLevel(), TypeNode.ASSET, parOffset++);
            env.addEntry(((ParamNode) a).getId(), entry);
            assetEntries.add(entry);
        }
        if (fields != null) {
            for (Node f : fields) {
                errors.addAll(f.checkSemantics(env));
            }
        }
        for (Node s : statements) {
            errors.addAll(s.checkSemantics(env));
            if (s instanceof CallNode c && c.getId().equals(id)) {
                isRecursive = true;
            }

            if (s instanceof IteNode i) {
                for (Node c : i.getStatements()) {
                    if (c instanceof CallNode call && call.getId().equals(id)) {
                        isRecursive = true;
                    }
                }
            }
        }
        env.exitScope();

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        for (Node f : fields) {
            f.typeCheck(env);
        }

        TypeNode t1 = TypeNode.VOID;
        boolean returnPresent = false;
        for (Node s : statements) {
            if (s instanceof RetNode) {
                returnPresent = true;
            }
            t1 = s.typeCheck(env);
        }

        boolean returnInItePresent = false;
        ArrayList<Integer> retPos = new ArrayList<>();
        for (Node s : statements) {
            if (s instanceof IteNode && ((IteNode) s).isReturnPresent()) {
                returnInItePresent = true;
                retPos.add(statements.indexOf(s));
            }
        }

        if (returnPresent && !(statements.get(statements.size() - 1) instanceof RetNode)) {
            throw new RuntimeException("There are statements after return statement");
        }

        if (returnInItePresent &&
                (!(statements.get(statements.size() - 1) instanceof IteNode)
                    || (retPos.get(0) != retPos.get(retPos.size()-1) ) )
        ) {
            throw new RuntimeException("There are statements after return statement");
        }

        if (t1 != type) {
            throw new RuntimeException("Return type does not match function type");
        }

        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        ArrayList<String> localAssets = new ArrayList<>(Functional.mapList(assets, a -> ((ParamNode) a).getId()));
        ArrayList<String> globalAssets = new ArrayList<>(Functional.mapList(this.globalAssets, a -> ((AssetNode) a).getId()));

        globalAssets = new ArrayList(Functional.filterList(globalAssets, a -> !localAssets.contains(a)));

        EffectsEnvironment sigma0 = env.copy();

        sigma0.enterScope();
        if (isRecursive) {
//            EffectsEnvironment sigma1 = sigma0.copy();
            for (String a : globalAssets) {
                sigma0.addEntry(
                        a,
                        new EffectsSTEntry(new NormalFormEffect(a), env.getNestLevel())
                );
            }

            for (Node a : assets) {
                sigma0.addEntry(
                        ((ParamNode) a).getId(),
                        new EffectsSTEntry(AssetEffect.Full(), env.getNestLevel())
                );
            }

            sigma0.addEntry(id, new EffectsSTEntry(new FunctionEffect(localAssets, globalAssets, sigma0, sigma0), env.getNestLevel()));

            EffectsEnvironment sigma1 = fixedPoint(sigma0);
            env.addEntry(id, sigma1.getLastEntry(id));
            return;
        }

        // TODO: parametrizzare asset parametri e globali
        for (String a : globalAssets) {
            sigma0.addEntry(
                    a,
                    new EffectsSTEntry(new NormalFormEffect(a), env.getNestLevel())
            );
        }

        for (Node a : assets) {
            String id = ((ParamNode) a).getId();
            sigma0.addEntry(
                    id,
                    new EffectsSTEntry(new NormalFormEffect(id), env.getNestLevel())
            );
        }

        EffectsEnvironment sigma1 = sigma0.copy();
        for (Node s : statements) {
            s.checkEffects(sigma1);
        }

        env.addEntry(id, new EffectsSTEntry(new FunctionEffect(localAssets, globalAssets, sigma0, sigma1), env.getNestLevel()));
    }

    private EffectsEnvironment fixedPoint(EffectsEnvironment sigma0) {
        EffectsEnvironment sigma1 = sigma0.copy();
        
        for (Node s : statements) {
            if (s instanceof CallNode c && c.getId().equals(id)) {
                ArrayList<String> localAssets = new ArrayList<>(Functional.mapList(assets, a -> ((ParamNode) a).getId()));
                ((FunctionEffect) sigma1.getEffect(id)).updateSigma1(sigma1);
                c.checkFixedPoint(sigma1, localAssets);
                continue;
//                break;
            }

            s.checkEffects(sigma1);

        }

        if (sigma0.equals(sigma1)) {
            return sigma1;
        }

        return fixedPoint(sigma1.copy());
    }

    @Override
    public String codeGeneration(Environment env) {

        String fieldsCode = "";
        if (fields != null)
            for (Node field : fields)
                fieldsCode += field.codeGeneration(env);

        String popDecl = "";
        if (declarations != null)
            for (Node dec : declarations)
                popDecl += "pop\n";

        String popAssets = "";
        if (assets != null)
            for (Node dec : assets)
                popAssets += "pop\n";

        String popFields = "";
        if (fields != null)
            for (Node dec : fields)
                popFields += "pop\n";

        String stmsCode = "";
        if (statements != null)
            for (Node stm : statements)
                stmsCode += stm.codeGeneration(env);

        int nPopStrings = 0;
        if (statements != null)
            for (Node stm : statements) {
                if (stm.getClass() == PrintNode.class
                        || stm.getClass() == CallNode.class
                        || stm.getClass() == IteNode.class
                        || stm.getClass() == RetNode.class
                ) {
                    nPopStrings++;
                }
            }

        String pushStms = "";
        String popStms = "";
        if (nPopStrings == 0) {
            pushStms += "push 0\n";
        } else {
            for (int i = 1; i < nPopStrings; i++) {
                popStms += "pop\n";
            }
        }

        String funl = AssetLanLib.freshFunLabel();
        AssetLanLib.putCode(funl + ":\n" +
                                    "cfp\n" +        // setta $fp a $sp
                                    "lra\n" +        // inserimento return address
                                    fieldsCode +
                                    stmsCode +
                                    pushStms +
                                    "srv\n" +        // pop del return value
                                    popFields +
                                    popStms +
                                    "sra\n" +        // pop del return address
                                    "pop\n" +        // pop di AL
                                    popDecl +
                                    popAssets +
                                    "sfp\n" +        // setto $fp a valore del CL
                                    "lrv\n" +        // risultato della funzione sullo stack
                                    "lra\n" + "js\n"  // salta a $ra
        );

        return "push " + funl + "\n";
    }
}
