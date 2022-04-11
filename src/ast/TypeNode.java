package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class TypeNode implements Node{
    String type;

    public TypeNode(String type) {
        this.type = type;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
