package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    private final HashMap<String, ArrayList<STEntry>> symTable = new HashMap<>();
    private final int offset = 0;
    private int nestLevel = -1;

    public int getOffset() {
        return offset;
    }

    public int getNestLevel() {
        return nestLevel;
    }

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

    //    Verifica che la variabile sia dichiarata in qualsiasi contesto
    public boolean isDeclared(String key) {
        ArrayList<STEntry> entries = symTable.get(key);
        if (entries == null) {
            return false;
        }

        return entries.size() > 0;
    }

    /*
    Verifica che la variabile sia dichiarata in uno specifico contesto.
    Da usare per verificare che una variabile venga dichiarata una e una sola volta in un contesto.
    */
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

    public void enterScope() {
        nestLevel++;
    }

    public void exitScope() {
        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, ArrayList<STEntry>> entry : symTable.entrySet()) {
            String key = entry.getKey();
            ArrayList<STEntry> entries = entry.getValue();
            if (entries.size() == 0) {
                continue;
            }

            STEntry last = entries.get(entries.size() - 1);
            if (last.getNestLevel() == nestLevel) {
                entries.remove(entries.size() - 1);
                if (entries.size() == 0) {
                    toRemove.add(key);
                }
            }
        }

        // Rimuove tutte le chiavi che non hanno più entry
        for (String key : toRemove) {
            symTable.remove(key);
        }

        nestLevel--;
    }
}
