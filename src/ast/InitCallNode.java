package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class InitCallNode implements Node {
    private String id;
    private ArrayList<Node> params;
    private ArrayList<Node> assets;

    public InitCallNode(String id, ArrayList<Node> params, ArrayList<Node> assets) {
        this.id = id;
        this.params = params;
        this.assets = assets;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        }
        for (Node param : params) {
            errors.addAll(param.checkSemantics(env));
        }
        for (Node asset : assets) {
            errors.addAll(asset.checkSemantics(env));
        }

        return errors;
    }
}
