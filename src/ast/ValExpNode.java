package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class ValExpNode implements Node {
    private int value;

    public ValExpNode(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<>();
    }
}
