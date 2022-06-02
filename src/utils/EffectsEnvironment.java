package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffectsEnvironment {
    private final HashMap<String, ArrayList<EffectsSTEntry>> eTable = new HashMap<>();
    private int nestLevel = -1;

    public EffectsEnvironment() {
        nestLevel++;
    }

    public void enterScope() {
        nestLevel++;
    }

    public void exitScope() {
        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, ArrayList<EffectsSTEntry>> entry : eTable.entrySet()) {
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
            eTable.remove(key);
        }

        nestLevel--;
    }

    public void setNestLevel(int nestLevel) {
        this.nestLevel = nestLevel;
    }

    public int getNestLevel() {
        return nestLevel;
    }
}

