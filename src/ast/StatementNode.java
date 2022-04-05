package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class StatementNode implements Node{
    private Node nodeStatement;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}