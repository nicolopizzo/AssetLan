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

    public void incOffset() {
        offset++;
    }

    public void decOffset() {
        offset--;
    }

    public void incNestLevel() {
        nestLevel++;
    }

    public void decNestLevel() {
        nestLevel--;
    }

    public void addEntry(String key, STEntry entry) {
        ArrayList<STEntry> entries = symTable.get(key);
    }
}

class SemanticException extends Exception {
    public SemanticException(String s) {
        super(s);
    }
}

class DuplicateNestLevelException extends SemanticException {
    public DuplicateNestLevelException() {
        super("NestLevelException: This variable has been already declared in this scope.");
    }
}

class DuplicateTypeException extends SemanticException {
    public DuplicateTypeException() {
        super("Type Exception: this variable has been already declared in this scope with a different type.");
    }
}

class EntityNotFoundException extends SemanticException {
    public EntityNotFoundException() {
        super("Entity not found exception: this variable/function has not been declared.");
    }
}
