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

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode t = exp.typeCheck(env);
        if (t != TypeNode.BOOL) {
            // TODO: handle the type error
        }
        return TypeNode.BOOL;
    }
}
