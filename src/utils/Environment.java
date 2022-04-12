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

    public STEntry lastInScope(String key) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null) {
            return null;
        }
        return entries.get(entries.size() - 1);
    }

    public boolean hasKey(String key) {
        return symTable.containsKey(key);
    }

    public boolean isEntityDeclared(String key) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null) {
            return false;
        }
        return lastInScope(key).getNestLevel() == nestLevel;
    }
}
