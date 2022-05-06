package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class RetNode implements Node {
    private Node returendExpression;

    public RetNode(Node returendExpression) {
        this.returendExpression = returendExpression;
    }

    public RetNode() {}

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (returendExpression != null) {
            errors.addAll(returendExpression.checkSemantics(env));
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return returendExpression.typeCheck(env);
    }
}
