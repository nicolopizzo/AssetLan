package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class AssignmentNode implements Node{

    private String id;
    private ExpNode exp;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}