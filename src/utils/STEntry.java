package utils;

import ast.TypeNode;

import java.util.ArrayList;

public class STEntry {
    private ArrayList<TypeNode> types = new ArrayList<>();
    private int nestLevel;
    private int offset;
    private boolean status;

    public STEntry(int nl, TypeNode type, int o) {
        types.add(type);
        nestLevel = nl;
        offset = o;
        status = false;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
