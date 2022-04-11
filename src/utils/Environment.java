package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
    private final HashMap<String, ArrayList<STEntry>> symTable = new HashMap<>();
    private int nestLevel = -1;
    private int offset = 0;

    public int getOffset() {
        return offset;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public HashMap<String, ArrayList<STEntry>> getSymTable() {
        return symTable;
    }

    public void incNestLevel() {
        nestLevel++;
    }

    public void decNestLevel() {
        nestLevel--;
    }

    public void addEntry(String key, STEntry entry) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null) {
            ArrayList<STEntry> singleton = new ArrayList<>();
            singleton.add(entry);
            symTable.put(key, singleton);
        }
    }

    public ArrayList<STEntry> lookup(String key) {
        return symTable.get(key);
    }
}
