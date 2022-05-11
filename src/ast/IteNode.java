package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class IteNode implements Node {

    private final Node condition;
    private final Node ifStatement;
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

    public boolean hasReturnNode() {
        if (ifStatement instanceof IteNode) {
            return ((IteNode) ifStatement).hasReturnNode();
        }

        if (elseStatement != null && elseStatement instanceof IteNode) {
            return ((IteNode) elseStatement).hasReturnNode();
        }

        boolean b1 = ifStatement instanceof RetNode;
        boolean b2 = elseStatement != null && elseStatement instanceof RetNode;

        return b1 || b2;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        //ArrayList<SemanticError> errors = new ArrayList<>();

        if (condition.typeCheck(env) != TypeNode.BOOL) {
            //errors.add(SemanticError.typeError("condition in if statement","bool"));
            throw new RuntimeException("Type Error - " + "condition in if statement" + " has type different from " + "bool");
        }

        if (ifStatement.typeCheck(env) != elseStatement.typeCheck(env)) {
            //errors.add(SemanticError.typeError("ifStatement","elseStatement"));
            throw new RuntimeException("Type Error - " + "ifStatement" + " has type different from " + "elseStatement");
        }

        return ifStatement.typeCheck(env);
    }
}