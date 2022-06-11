package ast;

import utils.EffectsEnvironment;
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
    public void checkEffects(EffectsEnvironment env) {
//        exp.checkEffects(env);
    }


    @Override
    public String codeGeneration(Environment env) {
        return exp.codeGeneration(env);
    }

    public int getValue() {
        if (exp instanceof ValExpNode) {
            return ((ValExpNode) exp).getValue();
        }

        if (exp instanceof BaseExpNode) {
            return ((BaseExpNode) exp).getValue();
        }

        if (exp instanceof BinExpNode) {
            return ((BinExpNode) exp).getValue();
        }

        return 0;
    }
}
