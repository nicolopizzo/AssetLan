package ast;

import utils.Environment;
import utils.SemanticError;
import utils.AssetLanLib;

import java.util.ArrayList;

public class NotExpNode implements Node {
    private Node exp;

    public NotExpNode(Node exp) {
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode t = exp.typeCheck(env);
        if (t != TypeNode.BOOL) {
            // TODO: handle the type error
            throw new RuntimeException("Type Error - " + "expression" + " has type different from " + "bool");
        }
        return TypeNode.BOOL;
    }

    @Override
    public void checkEffects(Environment env) {
        exp.checkEffects(env);
    }

    @Override
    public String codeGeneration(Environment env) {
        String ELSE = AssetLanLib.freshLabel();
        String END = AssetLanLib.freshLabel();
        return exp.codeGeneration(env)+
                "push 0\n"+
                "beq "+ ELSE +"\n"+
                "push 0\n"+
                "b " + END + "\n" +
                ELSE + ":push 1\n"+
                END + ":\n";
    }
}
