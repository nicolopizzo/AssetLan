package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class AdecNode implements Node{
    private ArrayList<String> ids;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}