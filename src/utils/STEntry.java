package utils;

import ast.TypeNode;

import java.util.ArrayList;

public class STEntry {
    private ArrayList<TypeNode> types = new ArrayList<>();
    private int nestLevel;
    private int offset;
    //status is used to manage the status of an asset (if zero)
    private boolean isFilled;

    public STEntry(int nl, TypeNode type, int o) {
        types.add(type);
        nestLevel = nl;
        offset = o;
        isFilled = false;
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

    public boolean isFilled() {
        return isFilled;
    }

    public void fill() {
        this.isFilled = true;
    }

    public void empty() {
        this.isFilled = false;
    }
}
