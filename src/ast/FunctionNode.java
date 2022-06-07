package ast;

import utils.AssetLanLib;
import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FunctionNode implements Node {
    private final TypeNode type;
    private final String id;
    private final ArrayList<Node> declarations;
    private final ArrayList<Node> assets;
    private final ArrayList<Node> fields;
    private final ArrayList<Node> statements;
    private final ArrayList<STEntry> assetEntries = new ArrayList<>();

    public FunctionNode(TypeNode type, String id, ArrayList<Node> declarations, ArrayList<Node> assets, ArrayList<Node> fields, ArrayList<Node> statements) {
        this.type = type;
        this.id = id;
        this.declarations = declarations;
        this.assets = assets;
        this.fields = fields;
        this.statements = statements;
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


        env.addEntry(id, new STEntry(env.getNestLevel(), types, env.getOffset()));

        env.enterScope();
        for (Node d : declarations) {
            errors.addAll(d.checkSemantics(env));
        }
        for (Node a : assets) {
            errors.addAll(a.checkSemantics(env));
            assetEntries.add(env.getLastEntry(((ParamNode) a).getId()));
        }
        for (Node f : fields) {
            errors.addAll(f.checkSemantics(env));
        }
        for (Node s : statements) {
            errors.addAll(s.checkSemantics(env));
        }
        env.exitScope();

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
//        for (Node d : declarations) {
//            d.typeCheck(env);
//        }
//        for (Node a : assets) {
//            a.typeCheck(env);
//        }
        for (Node f : fields) {
            f.typeCheck(env);
        }

        TypeNode t1 = TypeNode.VOID;
        for (Node s : statements) {
            t1 = s.typeCheck(env);
        }

        if (t1 != type) {
            throw new RuntimeException("Return type does not match function type");
        }

        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(Environment env) {

    }

    @Override
    public String codeGeneration(Environment env) {

        /*
        String declCode="";
        if (declarations!=null) for (Node dec:declarations)
            declCode+=dec.codeGeneration(env);
*/
        String fieldsCode="";
        if (fields!=null) for (Node field:fields)
            fieldsCode+=field.codeGeneration(env);
/*
        String popDecl="";
        if (declarations!=null)
            for (Node dec:declarations) popDecl+="pop\n";

        String popAssets="";
        for (Node dec:assets) popAssets+="pop\n";
        */

        String popFields="";
        for (Node dec:fields) popFields+="pop\n";

        String stmsCode="";
        for (Node stm:statements) stmsCode+=stm.codeGeneration(env);

        String funl= AssetLanLib.freshFunLabel();
        AssetLanLib.putCode(funl+":\n"+
                "cfp\n"+ 		// setta $fp a $sp
                "lra\n"+ 		// inserimento return address
                fieldsCode+ 		// inserimento dichiarazioni locali
                stmsCode+
                "srv\n"+ 		// pop del return value
                "sra\n"+ 		// pop del return address
                "pop\n"+ 		// pop di AL
                popFields+
                "sfp\n"+  		// setto $fp a valore del CL
                "lrv\n"+ 		// risultato della funzione sullo stack
                "lra\n"+"js\n"  // salta a $ra
        );

        return "push "+ funl +"\n";
    }
}
