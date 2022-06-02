package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class BoolExpNode implements Node {
    private boolean bool;

    public BoolExpNode(String bool) {
        this.bool = Boolean.parseBoolean(bool);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return TypeNode.BOOL;
    }

    @Override
    public void checkEffects(Environment env) {

    }


    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}
