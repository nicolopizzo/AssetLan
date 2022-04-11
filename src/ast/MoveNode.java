package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class MoveNode implements Node{

    private String id1;
    private String id2;

    public MoveNode(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}