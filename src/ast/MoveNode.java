package ast;

import utils.*;

import java.util.ArrayList;

public class MoveNode implements Node {

    private String id1;
    private String id2;

    private STEntry entry1;
    private STEntry entry2;

    private int nestinglevel;

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

        nestinglevel = env.getNestLevel();

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode t1 = entry1.getTypes().get(0);
        TypeNode t2 = entry2.getTypes().get(0);

        if (t1 != TypeNode.ASSET || t2 != TypeNode.ASSET) {
            throw new RuntimeException("Type Error - " + "the asset" + " has type different from " + "ASSET");
        }

        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        Effect e1 = env.getEffect(id1);
        Effect e2 = env.getEffect(id2);

        if (e1 instanceof AssetEffect a1 && e2 instanceof AssetEffect a2) {
            env.setEffect(id2, AssetEffect.max(a1, a2));
            env.setEffect(id1, AssetEffect.Empty());
        }

        if (e1 instanceof NormalFormEffect n1 && e2 instanceof NormalFormEffect n2) {
            env.setEffect(id2, NormalFormEffect.max(n1, n2));
            env.setEffect(id1, new NormalFormEffect("0"));
        }

        if (e1 instanceof AssetEffect a1 && e2 instanceof NormalFormEffect n2) {
            if (!a1.isEmpty()) {
                env.setEffect(id2, AssetEffect.Full());
            }
            env.setEffect(id1, AssetEffect.Empty());
        }

        if (e1 instanceof  NormalFormEffect n1 && e2 instanceof AssetEffect a2) {
            env.setEffect(id2, new NormalFormEffect("0"));
        }
    }


    @Override
    public String codeGeneration(Environment env) {
        StringBuilder getARx = new StringBuilder();
        for (int i=0; i<nestinglevel-entry1.getNestLevel(); i++)
            getARx.append("lw\n");

        StringBuilder getARy = new StringBuilder();
        for (int i=0; i<nestinglevel-entry2.getNestLevel(); i++)
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