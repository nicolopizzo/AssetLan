package ast;

import utils.*;

import java.util.ArrayList;

public class AssetNode implements Node {
    private String id;
    private final TypeNode type = TypeNode.ASSET;


    public AssetNode(String id) {
        this.id = id;
    }

    public TypeNode getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclaredInScope(id))
            env.addEntry(id, new STEntry(env.getNestLevel(), TypeNode.ASSET, env.offset--));
        else
            semanticErrors.add(SemanticError.duplicateDeclaration(id));

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return type;
    }

    @Override
    public void checkEffects(Environment env) {
    }

    @Override
    public String codeGeneration(Environment env) {
        return "";
    }
}
