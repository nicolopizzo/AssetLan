package utils;

import ast.TypeNode;

import java.util.ArrayList;


public class STEntry {
    private ArrayList<TypeNode> types = new ArrayList<>();
    private int nestLevel;
    private int offset;
    //status is used to manage the status of an asset (if zero)
    private Effect effect;

    public STEntry(int nl, TypeNode type, int o) {
        if (type == TypeNode.ASSET) {
            this.effect = Effect.EMPTY;
        } else {
            this.effect = Effect.BOT;
        }
        types.add(type);
        nestLevel = nl;
        offset = o;
    }

    public STEntry(int nl, ArrayList<TypeNode> types, int o) {
        this.types.addAll(types);
        nestLevel = nl;
        offset = o;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public int getOffset() {
        return offset;
    }

    public ArrayList<TypeNode> getTypes() {
        return types;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
