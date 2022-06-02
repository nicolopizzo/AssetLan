package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class IteNode implements Node {

    private final Node condition;
    private final ArrayList<Node> ifStatement;
    private ArrayList<Node> elseStatement;

    public IteNode(Node condition, ArrayList<Node> ifStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
    }

    public IteNode(Node condition, ArrayList<Node> ifStatement, ArrayList<Node> elseStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        errors.addAll(condition.checkSemantics(env));

        env.enterScope();
        for (Node node : ifStatement) {
            errors.addAll(node.checkSemantics(env));
        }
        env.exitScope();

        if (elseStatement != null) {
            env.enterScope();
            for (Node node : elseStatement) {
                errors.addAll(node.checkSemantics(env));
            }
            env.exitScope();
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        //ArrayList<SemanticError> errors = new ArrayList<>();
        TypeNode lastIf = TypeNode.VOID;


        if (condition.typeCheck(env) != TypeNode.BOOL) {
            //errors.add(SemanticError.typeError("condition in if statement","bool"));
            throw new RuntimeException("Type Error - " + "condition in if statement" + " has type different from " + "bool");
        }
        for (Node ifNode : ifStatement) {
            lastIf = ifNode.typeCheck(env);
        }

        if (elseStatement != null) {
            TypeNode lastElse = TypeNode.VOID;
            for (Node elseNode : elseStatement) {
                lastElse = elseNode.typeCheck(env);
            }

            if (lastIf != lastElse) {
                //errors.add(SemanticError.typeError("if and else statement","different type"));
                throw new RuntimeException("Type Error - " + "if and else statement" + " have different type");
            }

        }
        return lastIf;
    }

    @Override
    public void checkEffects(Environment env) {
        condition.checkEffects(env);

        for (Node node : ifStatement) {
            node.checkEffects(env);
        }

        if (elseStatement != null) {
            for (Node node : elseStatement) {
                node.checkEffects(env);
            }
        }


    }


    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}