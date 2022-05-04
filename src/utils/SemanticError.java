package utils;

public class SemanticError {
    private final String msg;

    public SemanticError(String message) {
        msg = message;
    }

    public static SemanticError duplicateDeclaration(String id){
        return new SemanticError("ID " + id + " already declared.");
    }

    public static SemanticError variableNotDeclared(String id){
        return new SemanticError("ID " + id + " is not declared.");
    }

    public static SemanticError typeError(String id, String id2) {
        return new SemanticError(id + " has type different from " + id2);
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
