package ast;

import utils.AssetLanLib;
import utils.EffectsEnvironment;
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

    boolean isIntOrAsset(TypeNode type1, TypeNode type2) {
        return (type1 != TypeNode.ASSET && type1 != TypeNode.INT) || (type2 != TypeNode.ASSET && type2 != TypeNode.INT);
    }

    boolean isBool(TypeNode type1, TypeNode type2) {
        return (type1 != TypeNode.BOOL || type2 != TypeNode.BOOL);
    }

    // If the binary expression has an arithmetic operator (+, -, *, /) return INT type
    // If the binary expression has a relational operator (>, <, >=, <=) return BOOL type
    // If the binary expression has a logical operator (&&, ||) return BOOL type
    // If the binary expression has an equality operator (==, !=) return BOOL type
    @Override
    public TypeNode typeCheck(Environment env) {

        TypeNode leftExp = left.typeCheck(env);
        TypeNode rightExp = right.typeCheck(env);

        if (op.isArithmetic()) {

            if (isIntOrAsset(leftExp, rightExp)) {
                throw new RuntimeException("Type Error - " + "expression" + " has type different from " + "int or asset");
            }

            return TypeNode.INT;

        } else if (op.isRelational()) {
            if (isIntOrAsset(leftExp, rightExp)) {
                throw new RuntimeException("Type Error - " + "expression" + " has type different from " + "int or asset");
            }
            return TypeNode.BOOL;

        } else if (op.isEquality()) {
            if ( isIntOrAsset(leftExp, rightExp) && isBool(leftExp, rightExp) ) {
                throw new RuntimeException("Type Error - " + "expression" + " has type different from " + "int or asset or bool");
            }
            return TypeNode.BOOL;

        } else {
            if (isBool(leftExp, rightExp)) {
                throw new RuntimeException("Type Error - " + "expression" + " has type different from " + "bool");
            }
            return TypeNode.BOOL;
        }

    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
//        left.checkEffects(env);
//        right.checkEffects(env);
    }

    @Override
    public String codeGeneration(Environment env) {
        String TRUE = AssetLanLib.freshLabel();
        String END = AssetLanLib.freshLabel();
        String FALSE = AssetLanLib.freshLabel();
        if (op.isArithmetic())
            return left.codeGeneration(env) +
                    right.codeGeneration(env) +
                    switch (op) {
                        case ADD -> "add\n";
                        case SUB -> "sub\n";
                        case MUL -> "mult\n";
                        case DIV -> "div\n";
                        default -> "";
                    };
        else if (op.isRelational())
            return left.codeGeneration(env) +
                    right.codeGeneration(env) +
                    switch (op) {
                        case LE ->
                            "bleq "+ TRUE +"\n"+
                            "push 0\n"+
                            "b " + END + "\n" +
                            TRUE + ":\n"+
                            "push 1\n"+
                            END + ":\n";
                        case GT ->
                            "bgt "+ TRUE +"\n"+
                            "push 0\n"+
                            "b " + END + "\n" +
                            TRUE + ":\n"+
                            "push 1\n"+
                            END + ":\n";
                        case LT ->
                            "blt "+ TRUE +"\n"+
                            "push 0\n"+
                            "b " + END + "\n" +
                            TRUE + ":\n"+
                            "push 1\n"+
                            END + ":\n";
                        case GE ->
                            "bgeq "+ TRUE +"\n"+
                            "push 0\n"+
                            "b " + END + "\n" +
                            TRUE + ":\n"+
                            "push 1\n"+
                            END + ":\n";
                        default -> "";
                    };
        else if (op.isEquality())
            return left.codeGeneration(env) +
                    right.codeGeneration(env) +
                    switch (op) {
                        case EQ ->
                                "beq "+ TRUE +"\n"+
                                        "push 0\n"+
                                        "b " + END + "\n" +
                                        TRUE + ":\n"+
                                        "push 1\n"+
                                        END + ":\n";
                        case NE ->
                                "beq "+ FALSE +"\n"+
                                        "push 1\n"+
                                        "b " + END + "\n" +
                                        FALSE + ":\n"+
                                        "push 0\n"+
                                        END + ":\n";
                        default -> "";
                    };
        else
            return switch (op) {
                        case AND ->
                                left.codeGeneration(env) +
                                "push 0\n"+
                                "beq "+ FALSE +"\n"+
                                right.codeGeneration(env) +
                                "push 0\n"+
                                "beq "+ FALSE +"\n"+
                                "push 1\n"+
                                "b " + END + "\n" +
                                FALSE + ":\n"+
                                "push 0\n"+
                                END + ":\n";
                        case OR ->
                                left.codeGeneration(env) +
                                "push 1\n"+
                                "beq "+ TRUE +"\n"+
                                right.codeGeneration(env) +
                                "push 1\n"+
                                "beq "+ TRUE +"\n"+
                                "push 0\n"+
                                "b " + END + "\n" +
                                TRUE + ":\n"+
                                "push 1\n"+
                                END + ":\n";
                        default -> "";
                    };
    }
}
