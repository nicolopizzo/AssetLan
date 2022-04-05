package utils;

public class SemanticError {
    private final String msg;

    public SemanticError(String message) {
        msg = message;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
