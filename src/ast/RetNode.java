package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class RetNode implements Node {
    private Node returendExpression;

    public RetNode(Node returendExpression) {
        this.returendExpression = returendExpression;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
