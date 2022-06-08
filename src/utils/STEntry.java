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
        types.add(type);
        nestLevel = nl;
        offset = o;
    }

    public STEntry(int nl, ArrayList<TypeNode> types, int o) {
        this.types.addAll(types);
        nestLevel = nl;
        offset = o;
    }

    public STEntry(int nl, int o) {
        types = new ArrayList<>();
        nestLevel = nl;
        offset = o;
    }

    public void setTypes(ArrayList<TypeNode> types) {
        this.types = types;
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

    //deepCopy()
    public STEntry deepCopy() {
        STEntry copy = new STEntry(nestLevel, types, offset);
        copy.setEffect(effect);
        return copy;
    }
}
