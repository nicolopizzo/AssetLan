package ast;

import utils.*;

import java.util.ArrayList;

public class AssetNode implements Node {
    private String id;
    private final TypeNode type = TypeNode.ASSET;


    public AssetNode(String id) {
        this.id = id;
    }


    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclaredInScope(id))
            env.addEntry(id, new STEntry(env.getNestLevel(), TypeNode.ASSET, env.getOffset()));
        else
            semanticErrors.add(SemanticError.duplicateDeclaration(id));

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        return type;
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        env.addEntry(id, new EffectsSTEntry(AssetEffect.Empty(), env.getNestLevel()));
    }

    @Override
    public String codeGeneration(Environment env) {
        return "";
    }

    public String getId() {
        return id;
    }
}
