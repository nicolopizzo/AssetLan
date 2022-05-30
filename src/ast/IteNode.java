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
        return null;
    }
}