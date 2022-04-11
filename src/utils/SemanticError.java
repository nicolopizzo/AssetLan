package utils;

public class SemanticError {
    private final String msg;

    public SemanticError(String message) {
        msg = message;
    }

    public static SemanticError duplicateDeclaration(String id){
        return new SemanticError("Variable " + id + " already declared.");
    }

    public static SemanticError variableNotDeclared(String id){
        return new SemanticError("Variable " + id + " is not declared.");
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
