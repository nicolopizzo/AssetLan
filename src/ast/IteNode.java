package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class IteNode implements Node {

    private Node condition;
    private Node ifStatement;
    private Node elseStatement;

    public IteNode(Node condition, Node ifStatement, Node statementElse) {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = statementElse;
    }

    public IteNode(Node condition, Node ifBody) {
        this.condition = condition;
        this.ifStatement = ifBody;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        errors.addAll(condition.checkSemantics(env));

        env.enterScope();
        errors.addAll(ifStatement.checkSemantics(env));
        env.exitScope();

        if (elseStatement != null) {
            env.enterScope();
            errors.addAll(elseStatement.checkSemantics(env));
            env.exitScope();
        }

        return errors;
    }

    @Override
    public Node typeCheck(Environment env) {
        return null;
    }
}