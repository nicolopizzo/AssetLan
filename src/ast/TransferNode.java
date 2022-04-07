package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class TransferNode implements Node{

    private String id;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}