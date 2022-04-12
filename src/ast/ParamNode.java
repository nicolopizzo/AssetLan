package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class ParamNode implements Node {
    Node type;
    String id;

    public ParamNode(Node type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
