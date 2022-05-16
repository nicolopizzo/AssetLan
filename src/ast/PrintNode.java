package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class PrintNode implements Node {

    private Node exp;

    public PrintNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        exp.typeCheck(env);
        return TypeNode.NULL;
    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}