package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class FunctionNode implements Node {
    private TypeNode type;
    private String id;
    private ArrayList<DecNode> declarations;
    private ArrayList<AdecNode> assets;
    private ArrayList<StatementNode> statements;

    public FunctionNode(TypeNode type, String id, ArrayList<DecNode> declarations, ArrayList<AdecNode> assets, ArrayList<StatementNode> statements) {
        this.type = type;
        this.id = id;
        this.declarations = declarations;
        this.assets = assets;
        this.statements = statements;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
