package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffectsEnvironment {
    private final HashMap<String, ArrayList<EffectsSTEntry>> table = new HashMap<>();
    private int nestLevel = -1;

    public EffectsEnvironment() {
        nestLevel++;
    }

    public void enterScope() {
        nestLevel++;
    }

    public void exitScope() {
        List<String> toRemove = new ArrayList<>();

        for (Map.Entry<String, ArrayList<EffectsSTEntry>> entry : table.entrySet()) {
            String key = entry.getKey();
            ArrayList<EffectsSTEntry> entries = entry.getValue();

            //last entry can contain the current level
            //so instead of using a for cycle for all element in the list we can search only for the last entry
            EffectsSTEntry last = entries.get(entries.size() - 1);
            if (last.getNestLevel() == nestLevel) {
                entries.remove(entries.size() - 1);
                if (entries.size() == 0) {
                    toRemove.add(key);
                }
            }
        }

        //removes all keys that have no more entries
        for (String key : toRemove) {
            table.remove(key);
        }

        nestLevel--;
    }

    // add entry
    public void addEntry(String id, EffectsSTEntry entry) {
        if (!table.containsKey(id)) {
            table.put(id, new ArrayList<EffectsSTEntry>());
        }
        table.get(id).add(entry);
    }

    //get last effect
    public EffectsSTEntry getLastEntry(String id) {
        if (!table.containsKey(id)) {
            return null;
        }
        return table.get(id).get(table.get(id).size() - 1);
    }

    public Effect getEffect(String id) {
        if (!table.containsKey(id)) {
            return null;
        }
        return table.get(id).get(table.get(id).size() - 1).getEffect();
    }

    public void setEffect(String id, Effect e) {
        if (!table.containsKey(id)) {
            table.put(id, new ArrayList<EffectsSTEntry>());
        }

        getLastEntry(id).setEffect(e);
//        table.get(id).add(new EffectsSTEntry(e));
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public static EffectsEnvironment max(EffectsEnvironment sigma0, EffectsEnvironment sigma1) {
        // Suppongo dom(sigma0) = dom(sigma1), nestLevel(sigma0) = nestLevel(sigma1)

        EffectsEnvironment sigma = sigma0.copy();
        for (String key : sigma.table.keySet()) {
            int size = sigma.table.get(key).size();
            for (int i = 0; i < size; i++) {
                EffectsSTEntry e0 = sigma0.table.get(key).get(i);
                EffectsSTEntry e1 = sigma1.table.get(key).get(i);

                sigma.table.get(key).get(i).setEffect(Effect.max(e0.getEffect(), e1.getEffect()));
            }
        }

        return sigma;
    }

    // deep copy
    public EffectsEnvironment copy() {
        EffectsEnvironment copy = new EffectsEnvironment();
        copy.nestLevel = nestLevel;
        for (Map.Entry<String, ArrayList<EffectsSTEntry>> entry : table.entrySet()) {
            String key = entry.getKey();
            ArrayList<EffectsSTEntry> entries = entry.getValue();
            ArrayList<EffectsSTEntry> copyEntries = new ArrayList<>();
            for (EffectsSTEntry e : entries) {
                copyEntries.add(e.copy());
            }
            copy.table.put(key, copyEntries);
        }
        return copy;
    }

    public void update(EffectsEnvironment sigma1) {
        for (String key : sigma1.table.keySet()) {
            if (!table.containsKey(key)) continue;

            ArrayList<EffectsSTEntry> entries = table.get(key);
            ArrayList<EffectsSTEntry> sigma1Entries = sigma1.table.get(key);

            entries = (ArrayList<EffectsSTEntry>) sigma1Entries.clone();
        }
    }

}

