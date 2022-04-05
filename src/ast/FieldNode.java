package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class FieldNode implements Node {
    private TypeNode type;
    private String id;
    private ExpNode exp;

    public FieldNode(TypeNode type, String id, ExpNode exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    public TypeNode getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public ExpNode getExp() {
        return exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
