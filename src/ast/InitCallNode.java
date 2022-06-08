package ast;

import utils.*;

import java.util.ArrayList;
import java.util.List;

public class InitCallNode implements Node {
    private String id;
    private ArrayList<Node> params;
    private ArrayList<Node> assets;
    private STEntry symEntry;
    private int nestinglevel;

    public InitCallNode(String id, ArrayList<Node> params, ArrayList<Node> assets) {
        this.id = id;
        this.params = params;
        this.assets = assets;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
            nestinglevel = env.getNestLevel();
        }
        for (Node param : params) {
            errors.addAll(param.checkSemantics(env));
        }
        for (Node asset : assets) {
            errors.addAll(asset.checkSemantics(env));
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        // TODO: check the given parameters correspond to the ones in the definition of the function.
        List<TypeNode> toCompare = Environment.getParamsType(symEntry);

        ArrayList<TypeNode> paramsTypes = new ArrayList<>();
        paramsTypes.addAll(Functional.mapList(params, p -> p.typeCheck(env)));
        paramsTypes.addAll(Functional.mapList(assets, a -> a.typeCheck(env)));

        if (toCompare.size() != paramsTypes.size()) {
            // TODO: handle type errors
            throw new RuntimeException("Type error: wrong number of parameters");
        }

        for (int i = 0; i < toCompare.size(); i++){
            TypeNode t1 = toCompare.get(i);
            TypeNode t2 = paramsTypes.get(i);

            if (t1 == TypeNode.ASSET && (t2 == TypeNode.ASSET || t2 == TypeNode.INT)) {
                continue;
            }

            if (t1 != t2) {
                // TODO: handle type errors
                throw new RuntimeException("Type error: wrong type of parameter (" + t1 + " != " + t2 + ")");
            }
        }

        return env.getType(id);
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        // TODO: handle effects
    }

    @Override
    public String codeGeneration(Environment env) {
        String parCode="";
        for (int i=params.size()-1; i>=0; i--)
            parCode+=params.get(i).codeGeneration(env);

        String aparCode="";
        for (int i=assets.size()-1; i>=0; i--)
            aparCode+=assets.get(i).codeGeneration(env);

        String getAR="";
        for (int i=0; i<nestinglevel-symEntry.getNestLevel(); i++)
            getAR+="lw\n"; // formato AR: control_link+parameters+access_link+dich_locali

        return "lfp\n"+ 				// CL
                aparCode+
                parCode+
                "lfp\n"+
                getAR+ 		// setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push "+symEntry.getOffset()+"\n"+ // metto offset sullo stack
                "lfp\n"+
                getAR+ 		// risalgo la catena statica
                "add\n"+
                "lw\n"+ 				// carico sullo stack il valore all'indirizzo ottenuto
                "js\n";
    }
}
