package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class BinExpNode implements Node {
    Node left;
    Node right;
    BinaryOperator op;

    public BinExpNode(Node left, Node right, BinaryOperator op) {
        this.left = left;
        this.right = right;
        this.op = op;
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
        //ArrayList<SemanticError> errors = new ArrayList<>();
        if (left.typeCheck(env) != right.typeCheck(env)) {
            //errors.add(SemanticError.typeError("left expression","right expression"));
            throw new RuntimeException("Type Error - " + "left expression" + " has type different from " + "right expression");
        }

        // If the binary expression has an arithmetic operator (+, -, *, /) return INT type
        // Else the binary expression has boolean operator (&&, ||, !=, ==, <, <=, >, >=)
        if (op.isArithmetic()) {
            return TypeNode.INT;
        } else{
            return TypeNode.BOOL;
        }

    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}
