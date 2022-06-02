package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class BaseExpNode implements Node {
    Node exp;

    public BaseExpNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }

    @Override
    public TypeNode typeCheck(Environment env){
        return exp.typeCheck(env);
    }

    @Override
    public void checkEffects(Environment env) {
        exp.checkEffects(env);
    }


    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}
