package ast;

import utils.*;

import java.util.ArrayList;
import java.util.List;

public class CallNode implements Node {
    private String id;
    private ArrayList<Node> exp;
    private ArrayList<String> ids;
    private STEntry symEntry;
    private ArrayList<STEntry> assetEntries = new ArrayList<>();
    private int nestinglevel;

    public CallNode(String id, ArrayList<Node> exp, ArrayList<String> ids) {
        this.id = id;
        this.exp = exp;
        this.ids = ids;
    }

    public String getId() {
        return id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        // Check if the function is defined somewhere
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
            nestinglevel = env.getNestLevel();
        }

        for (Node e : exp) {
            errors.addAll(e.checkSemantics(env));
        }

        // Check if some assets are not declared
        for (String myId : ids) {
            if (!env.isDeclared(myId)) {
                errors.add(SemanticError.variableNotDeclared(myId));
            } else {
                assetEntries.add(env.getLastEntry(myId));
            }
        }

        return errors;
    }

    private TypeNode getTypeOfId(String id){
        TypeNode idType = null;
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                idType = assetEntries.get(i).getTypes().get(0);
            }
        }
        if (idType == null) {
            throw new RuntimeException("Type error: wrong type of parameter ( type of " + id + " is " + null + ")");
        }
        return idType;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        List<TypeNode> paramsType = Environment.getParamsType(symEntry);

        ArrayList<TypeNode> givenParams = new ArrayList<>();
        givenParams.addAll(Functional.mapList(exp, e -> e.typeCheck(env)));
        givenParams.addAll(Functional.mapList(ids, id -> getTypeOfId(id) ));

        if (paramsType.size() != givenParams.size()) {
            throw new RuntimeException("Type error: wrong number of parameters");
        }

        for (int i = 0; i < paramsType.size(); i++) {
            TypeNode t1 = paramsType.get(i);
            TypeNode t2 = givenParams.get(i);

            if (!(t1 == TypeNode.ASSET && (t2 == TypeNode.ASSET || t2 == TypeNode.INT))
                    && !(t1 == TypeNode.INT && (t2 == TypeNode.ASSET || t2 == TypeNode.INT))
                    && !(t1 == TypeNode.BOOL && t2 == TypeNode.BOOL)) {
                throw new RuntimeException("Type error: wrong type of actual and formal parameters (" + t1 + " != " + t2 + ")");
            }
        }

        applyEffect();
        return Environment.getType(symEntry);
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        // TODO: handle effects, check if function is recursive for fixed point, check local liquidity
    }

    @Override
    public String codeGeneration(Environment env) {

        String parCode = "";
        for (int i = exp.size() - 1; i >= 0; i--)
            parCode += exp.get(i).codeGeneration(env);

        String aparCode = "";
        for (int i = assetEntries.size() - 1; i >= 0; i--) {
            String getAR = "";
            for (int j = nestinglevel - assetEntries.get(i).getNestLevel()-1; j >= 0; j--)
                getAR += "lw\n";
            aparCode += "push " + assetEntries.get(i).getOffset() + "\n" + //metto offset sullo stack
                    "lfp\n" + getAR + //risalgo la catena statica
                    "add\n" +
                    "lw\n"+
                    "push 0\n"+
                    "push " + assetEntries.get(i).getOffset() + "\n" + //metto offset sullo stack
                    "lfp\n" + getAR + //risalgo la catena statica
                    "add\n" +
                    "sw\n";
        }


        String getAR = "";
        for (int i = 0; i < nestinglevel - symEntry.getNestLevel(); i++)
            getAR += "lw\n";
        // formato AR: control_link+parameters+access_link+dich_locali
        return "lfp\n" +                // CL
                aparCode +
                parCode +
                "lfp\n" + getAR +        // setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push " + symEntry.getOffset() + "\n" + // metto offset sullo stack
                "lfp\n" + getAR +        // risalgo la catena statica
                "add\n" +
                "lw\n" +                // carico sullo stack il valore all'indirizzo ottenuto
                "js\n";

    }

    private void applyEffect() {
        //  assetEntries.forEach(stEntry -> stEntry.empty());
    }
}