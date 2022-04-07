package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class AssetNode implements Node {
    private String id;

    public AssetNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
