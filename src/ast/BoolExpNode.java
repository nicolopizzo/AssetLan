package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class BoolExpNode implements Node {
    private boolean bool;

    public BoolExpNode(String bool) {
        this.bool = Boolean.parseBoolean(bool);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }

    @Override
    public Node typeCheck(Environment env) {
        return null;
    }
}
