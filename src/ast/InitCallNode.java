package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class InitCallNode implements Node {
    String id;
    ArrayList<Node> params;
    ArrayList<Node> assets;

    public InitCallNode(String id, ArrayList<Node> params, ArrayList<Node> assets) {
        this.id = id;
        this.params = params;
        this.assets = assets;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
