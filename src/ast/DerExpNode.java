package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class DerExpNode implements Node {
    String id;
    private STEntry symEntry;

    public DerExpNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> res = new ArrayList<>();
        if (!env.isDeclared(id)) {
            res.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
        }
        return res;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return Environment.getType(symEntry);
    }
}
