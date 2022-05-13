package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class TransferNode implements Node {

    private String id;
    private STEntry entry;

    public TransferNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclared(id))
            semanticErrors.add(SemanticError.variableNotDeclared(id));
        else
            entry = env.getLastEntry(id);

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        applyEffect();
        return TypeNode.NULL;
    }

    private void applyEffect() {
        entry.empty();
    }
}