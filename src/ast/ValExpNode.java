package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class ValExpNode implements Node {
    String value;

    public ValExpNode(String value) {
        this.value = value;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
