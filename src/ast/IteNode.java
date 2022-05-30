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

        if (condition.typeCheck(env) != TypeNode.BOOL) {
            //errors.add(SemanticError.typeError("condition in if statement","bool"));
            throw new RuntimeException("Type Error - " + "condition in if statement" + " has type different from " + "bool");
        }
        for (Node ifNode : ifStatement) {
            ifNode.typeCheck(env);
        }

        if (elseStatement != null) {
            Node lastIf = ifStatement.get(ifStatement.size() - 1);
            Node lastElse = elseStatement.get(elseStatement.size() - 1);

            if (lastIf != lastElse) {
                //errors.add(SemanticError.typeError("last if statement","last else statement"));
                throw new RuntimeException("Type Error - " + "last if statement" + " has type different from " + "last else statement");
            }

            for (Node elseNode : elseStatement) {
                elseNode.typeCheck(env);
            }
        }

        return TypeNode.NULL;
    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}