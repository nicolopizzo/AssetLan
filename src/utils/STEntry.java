package utils;

import ast.TypeNode;

import java.util.ArrayList;

public class STEntry {
    private ArrayList<TypeNode> types = new ArrayList<>();
    private int nestLevel;
    private int offset;

    public STEntry(int nl, TypeNode type, int o) {
        types.add(type);
        nestLevel = nl;
        offset = o;
    }

    public STEntry(int nl, ArrayList<TypeNode> types, int o) {
        types.addAll(types);
        nestLevel = nl;
        offset = o;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public int getOffset() {
        return offset;
    }
}
