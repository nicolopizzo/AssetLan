package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class IteNode implements Node{

    private Node statementIf;
    private Node statementElse;
    private Node exp;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}