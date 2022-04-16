package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    private final HashMap<String, ArrayList<STEntry>> symTable = new HashMap<>();
    private final int offset = 0;
    //current nestLevel to use when visit the custom tree to create the sym table
    private int nestLevel = -1;

    public int getOffset() {
        return offset;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    //addEntry() adds a new ID into the sym table storing also his nestLevel (with STEntry class)
    //addEntry() is called only when we already know that there are no semantic errors (e.g. multiple declaration)
    public void addEntry(String key, STEntry entry) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null) {
            ArrayList<STEntry> singleton = new ArrayList<>();
            singleton.add(entry);
            symTable.put(key, singleton);
        } else {
            entries.add(entry);
        }
    }

    //isDeclared() verifies that the variable is declared in some context
    public boolean isDeclared(String key) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null) {
            return false;
        }
        return entries.size() > 0;
    }

    // isDeclaredInScope() verifies that the variable is declared in the last context
    public boolean isDeclaredInScope(String key) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null || entries.size() == 0) {
            return false;
        }

        STEntry last = entries.get(entries.size() - 1);
        if (last == null) {
            return false;
        }
        return last.getNestLevel() == nestLevel;
    }

    //when enter in a new scope increment the nestLevel
    public void enterScope() {
        nestLevel++;
    }

    //when exit from a scope decrement the nestLevel
    //and for all variable declared in this scope deletes from the list the STEntry with current nest level
    public void exitScope() {
        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, ArrayList<STEntry>> entry : symTable.entrySet()) {
            String key = entry.getKey();
            ArrayList<STEntry> entries = entry.getValue();

            //last entry can contain the current level
            //so instead of using a for cycle for all element in the list we can search only for the last entry
            STEntry last = entries.get(entries.size() - 1);
            if (last.getNestLevel() == nestLevel) {
                entries.remove(entries.size() - 1);
                if (entries.size() == 0) {
                    toRemove.add(key);
                }
            }
        }

        //removes all keys that have no more entries
        for (String key : toRemove) {
            symTable.remove(key);
        }

        nestLevel--;
    }
}
