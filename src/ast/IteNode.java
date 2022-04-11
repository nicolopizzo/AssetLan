package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class IteNode implements Node{

    private Node exp;
    private Node statementIf;
    private Node statementElse;

    public IteNode(Node exp, Node statementIf, Node statementElse) {
        this.exp = exp;
        this.statementIf = statementIf;
        this.statementElse = statementElse;
    }

    public IteNode(Node exp, Node statementIf) {
        this.exp = exp;
        this.statementIf = statementIf;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}