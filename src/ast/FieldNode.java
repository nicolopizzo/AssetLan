package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class FieldNode implements Node {
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
