package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class DerExpNode extends ExpNode{
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return super.checkSemantics(env);
    }
}
