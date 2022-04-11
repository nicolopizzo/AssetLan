package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
    String id;

    public DerExpNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
