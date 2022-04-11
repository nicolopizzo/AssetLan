package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class BoolExpNode implements Node {
    String bool;

    public BoolExpNode(String bool) {
        this.bool = bool;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
