package utils;

public class STEntry {
    private int nestLevel;
    private int offset;

    public STEntry(int nl, int o) {
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
