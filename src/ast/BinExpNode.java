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
        //ArrayList<SemanticError> errors = new ArrayList<>()
        // If the binary expression has an arithmetic operator (+, -, *, /) return INT type
        // Else the binary expression has boolean operator (&&, ||, !=, ==, <, <=, >, >=)
        // relational (!=, ==, <, <=, >, >=)
        TypeNode leftExp = left.typeCheck(env);
        TypeNode rightExp = right.typeCheck(env);

        if (op.isArithmetic()) {

            if ((leftExp != TypeNode.ASSET && leftExp != TypeNode.INT) || (rightExp != TypeNode.ASSET && rightExp != TypeNode.INT)) {
                throw new RuntimeException("Type Error - " + "left expression" + " has type different from " + "right expression");
            }

            return TypeNode.INT;

        } else if (op.isRelational()) {
            if ((leftExp != TypeNode.ASSET && leftExp != TypeNode.INT) || (rightExp != TypeNode.ASSET && rightExp != TypeNode.INT)) {
                throw new RuntimeException("Type Error - " + "left expression" + " has type different from " + "right expression");
            }
            return TypeNode.BOOL;

        } else if (op.isEquality()) {
            if ((leftExp != TypeNode.ASSET || leftExp != TypeNode.INT) || (rightExp != TypeNode.ASSET || rightExp != TypeNode.INT)
                    || (leftExp != TypeNode.BOOL || leftExp != TypeNode.BOOL)) {
                throw new RuntimeException("Type Error - " + "left expression" + " has type different from " + "right expression");
            }
            return TypeNode.BOOL;

        } else {
            if (leftExp != TypeNode.BOOL || rightExp != TypeNode.BOOL) {
                throw new RuntimeException("Type Error - " + "left expression" + " has type different from " + "right expression");
            }
            return TypeNode.BOOL;
        }

    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}
