package utils;

import java.util.HashMap;
import java.util.List;

public class Environment {
    private final HashMap<String, List<STEntry>> symTable = new HashMap<>();
    private int nestLevel = -1;
    private int offset = 0;

    public int getOffset() {
        return offset;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public HashMap<String, List<STEntry>> getSymTable() {
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

    public SemanticError addEntry(String key, STEntry entry) {
        return null;
    }

    private boolean checkTable(String key, STEntry entry) throws SemanticException {
        return false;
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
