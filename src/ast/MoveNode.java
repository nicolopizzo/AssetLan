package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class MoveNode implements Node{

    private String id1;
    private String id2;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}