package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class NotExpNode implements Node {
    private Node exp;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }
}
