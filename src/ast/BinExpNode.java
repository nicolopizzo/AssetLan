package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class BinExpNode implements Node {
    Node left;
    Node right;

    public BinExpNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        errors.addAll(left.checkSemantics(env));
        errors.addAll(right.checkSemantics(env));
        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if(left.typeCheck(env) != right.typeCheck(env)) {
            errors.add(SemanticError.typeError("left expression","right expression"));
        }
        return left.typeCheck(env);
    }
}
