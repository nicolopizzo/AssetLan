package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;


public class ProgramNode implements Node {
    private ArrayList<FieldNode> fields;
    private ArrayList<AssetNode> assets;
    private ArrayList<FunctionNode> functions;
    private InitCallNode initCall;

    public ProgramNode(ArrayList<FieldNode> fields, ArrayList<AssetNode> assets, ArrayList<FunctionNode> functions, InitCallNode initCall) {
        this.fields = fields;
        this.assets = assets;
        this.functions = functions;
        this.initCall = initCall;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}
