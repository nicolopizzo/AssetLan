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
    public Node typeCheck(Environment env) {
        if(left.typeCheck(env) != right.typeCheck(env)) {
        // TODO: gestire errore di tipo
        System.out.println("Errore di tipo in BinExpNode");
        }
        return null;
    }
}
