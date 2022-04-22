package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class TypeNode implements Node{
    private final String type;

    public TypeNode(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }
}
