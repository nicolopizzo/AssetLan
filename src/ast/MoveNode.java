package ast;

import utils.*;

import java.util.ArrayList;

public class MoveNode implements Node {

    private String id1;
    private String id2;

    private STEntry entry1;
    private STEntry entry2;

    public MoveNode(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclared(id2)) {
            semanticErrors.add(SemanticError.variableNotDeclared(id2));
        } else {
            entry2 = env.getLastEntry(id2);
        }

        if (!env.isDeclared(id1)) {
            semanticErrors.add(SemanticError.variableNotDeclared(id1));
        } else {
            entry1 = env.getLastEntry(id1);
        }

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode t1 = entry1.getTypes().get(0);
        TypeNode t2 = entry2.getTypes().get(0);

        //ArrayList<SemanticError> errors = new ArrayList<>();
        if (t1 != TypeNode.ASSET || t2 != TypeNode.ASSET) {
            //errors.add(SemanticError.typeError(id1, id2));
            throw new RuntimeException("Type Error - " + "the asset" + " has type different from " + "ASSET");
        }

        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        Effect e1 = entry1.getEffect();
        Effect e2 = entry2.getEffect();

        env.setEffect(id1, Effect.EMPTY);
        env.setEffect(id2, Effect.max(e1, e2));
//        entry2.setEffect(e1.assetMax(e2));
//        entry1.setEffect(Effect.EMPTY);
//        entry1.setEffect(entry1.getEffect().assetMax(effect));
    }


    @Override
    public String codeGeneration(Environment env) {
        StringBuilder getARx = new StringBuilder();
        for (int i=0; i<env.getNestLevel()-entry1.getNestLevel(); i++)
            getARx.append("lw\n");

        StringBuilder getARy = new StringBuilder();
        for (int i=0; i<env.getNestLevel()-entry1.getNestLevel(); i++)
            getARy.append("lw\n");

        return "push "+entry1.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getARx+ //risalgo la catena statica
                "add\n"+
                "lw\n"+
                "push "+entry2.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getARy+ //risalgo la catena statica
                "add\n"+
                "lw\n"+
                "add\n"+
                "push "+entry2.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getARy+ //risalgo la catena statica
                "add\n"+
                "sw\n"+
                "push 0\n"+
                "push "+entry1.getOffset()+"\n"+ //metto offset sullo stack
                "lfp\n"+getARx+ //risalgo la catena statica
                "add\n"+
                "sw\n";
    }
}