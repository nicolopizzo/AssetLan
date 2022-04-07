package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class CallNode implements Node{

    private String id;
    private ArrayList<ExpNode> exp;
    private ArrayList<String> ids;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}