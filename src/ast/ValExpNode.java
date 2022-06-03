package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class ValExpNode implements Node {
    private int value;

    public ValExpNode(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return TypeNode.INT;
    }

    @Override
    public void checkEffects(Environment env) {

    }

    @Override
    public String codeGeneration(Environment env) {
        return "push "+value+"\n";
    }
}
