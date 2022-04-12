package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class AssetNode implements Node {
    private String id;

    public AssetNode(String id) {
        this.id = id;
    }


    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isEntityDeclared(id))
            env.addEntry(id, new STEntry(env.getNestLevel(), env.getOffset()));
        else
            semanticErrors.add(SemanticError.duplicateDeclaration(id));

        return semanticErrors;
    }
}
