package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class NegExpNode implements Node {
    private Node exp;

    public NegExpNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }

    @Override
    public Node typeCheck(Environment env) {
        return null;
    }
}
