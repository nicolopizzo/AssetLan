package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class PrintNode implements Node{

    private ExpNode exp;

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }
}