package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class TransferNode implements Node {

    private String id;

    public TransferNode(String id) {
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclared(id))
            semanticErrors.add(SemanticError.variableNotDeclared(id));

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return TypeNode.NULL;
    }
}