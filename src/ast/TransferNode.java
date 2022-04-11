package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class TransferNode implements Node{

    private String id;

    public TransferNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}