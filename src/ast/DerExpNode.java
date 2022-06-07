package ast;

import utils.Effect;
import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
    String id;
    private STEntry symEntry;
    private int nestinglevel;

    public DerExpNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        if (!env.isDeclared(id)) {
            res.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
            nestinglevel = env.getNestLevel();
        }
        return res;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return Environment.getType(symEntry);
    }

    @Override
    public void checkEffects(Environment env) {
        if (Environment.getType(symEntry) != TypeNode.ASSET) {
            Effect effect = symEntry.getEffect();
            symEntry.setEffect(effect.rightExp());
        }
    }

    @Override
    public String codeGeneration(Environment env) {
        String getAR="";
        for (int i=0; i<nestinglevel-symEntry.getNestLevel(); i++)
            getAR+="lw\n";
        return "push "+symEntry.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+
                getAR+ //risalgo la catena statica
                "add\n"+
                "lw\n"; //carico sullo stack il valore all'indirizzo ottenuto
    }
}
