package ast;

import utils.*;

import java.util.ArrayList;

public class TransferNode implements Node {

    private String id;
    private STEntry entry;

    private int nestinglevel;

    public TransferNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclared(id))
            semanticErrors.add(SemanticError.variableNotDeclared(id));
        else{
            entry = env.getLastEntry(id);
            nestinglevel = env.getNestLevel();
        }

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        if (entry.getTypes().get(0) != TypeNode.ASSET){
            throw new RuntimeException("Type Error - " + id + " has type different from " + "ASSET");
        }
        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        env.setEffect(id, AssetEffect.Empty());
    }

    @Override
    public String codeGeneration(Environment env) {
        String getAR="";
        for (int i=0; i<nestinglevel-entry.getNestLevel(); i++)
            getAR+="lw\n";
        return "push "+entry.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getAR+ //risalgo la catena statica
                "add\n"+
                "lw\n"+
                "srvi\n"+
                "push 0\n"+
                "push "+entry.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getAR+ //risalgo la catena statica
                "add\n"+
                "sw\n";
    }
}