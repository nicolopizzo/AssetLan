package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class DecNode implements Node{
    private ArrayList<Node> typeNodes;
    private ArrayList<String> ids;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
