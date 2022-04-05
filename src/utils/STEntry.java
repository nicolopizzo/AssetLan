package utils;

import ast.Node;

public class STEntry {
    private int nestLevel;
    private Node type;
    private int offset;

    public STEntry(int nl, Node t, int o) {
        nestLevel = nl;
        type = t;
        offset = o;
    }

    public STEntry(int nl, int o) {
        nestLevel = nl;
        offset = o;
    }

    public Node getType() {
        return type;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public int getOffset() {
        return offset;
    }
}
