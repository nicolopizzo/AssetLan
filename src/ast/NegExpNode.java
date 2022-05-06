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
    public TypeNode typeCheck(Environment env) {
        TypeNode t1 = exp.typeCheck(env);
        if (t1 != TypeNode.INT) {
            // TODO: gestire l'errore correttamente
            throw new RuntimeException("Type Error - " + "expression" + " has type different from " + "int");
        }
        return TypeNode.INT;
    }
}
