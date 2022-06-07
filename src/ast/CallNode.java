package ast;

import utils.Environment;
import utils.Functional;
import utils.STEntry;
import utils.SemanticError;

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

    @Override
    public TypeNode typeCheck(Environment env) {
        List<TypeNode> paramsType = Environment.getParamsType(symEntry);

        ArrayList<TypeNode> givenParams = new ArrayList<>();
        givenParams.addAll(Functional.mapList(exp, e -> e.typeCheck(env)));
        givenParams.addAll(Functional.mapList(ids, id -> env.getType(id)));

        if (paramsType.size() != givenParams.size()) {
            // TODO: handle type errors
            throw new RuntimeException("Type error: wrong number of parameters");
        }

        for (int i = 0; i < paramsType.size(); i++){
            TypeNode t1 = paramsType.get(i);
            TypeNode t2 = givenParams.get(i);

            if (t1 != t2) {
                // TODO: handle type errors
                throw new RuntimeException("Type error: wrong type of parameter (" + t1 + " != " + t2 + ")");
            }
        }

        applyEffect();
        return env.getType(id);
    }

    @Override
    public void checkEffects(Environment env) {
        // TODO: handle effects, check if function is recursive for fixed point, check local liquidity
    }

    @Override
    public String codeGeneration(Environment env) {

        String parCode="";
	    for (int i=exp.size()-1; i>=0; i--)
	    	parCode+=exp.get(i).codeGeneration(env);

        String aparCode="";
        for (STEntry assetEntry : assetEntries) {
            String getAR = "";
            for (int i = 0; i < nestinglevel - assetEntry.getNestLevel(); i++)
                getAR += "lw\n";
            aparCode += "push " + assetEntry.getOffset() + "\n" + //metto offset sullo stack
                    "lfp\n" + getAR + //risalgo la catena statica
                    "add\n" +
                    "lw\n";
        }

	    String getAR="";
		  for (int i=0; i<nestinglevel-symEntry.getNestLevel(); i++)
		    	 getAR+="lw\n";
		  					// formato AR: control_link+parameters+access_link+dich_locali
		return "lfp\n"+ 				// CL
               parCode+
               aparCode+
               "lfp\n"+getAR+ 		// setto AL risalendo la catena statica
               						// ora recupero l'indirizzo a cui saltare e lo metto sullo stack
               "push "+symEntry.getOffset()+"\n"+ // metto offset sullo stack
		       "lfp\n"+getAR+ 		// risalgo la catena statica
			   "add\n"+
               "lw\n"+ 				// carico sullo stack il valore all'indirizzo ottenuto
		       "js\n";

    }

    private void applyEffect() {
     //  assetEntries.forEach(stEntry -> stEntry.empty());
    }
}