package ast;

import utils.*;

import java.util.ArrayList;

public class AssetNode implements Node {
    private String id;
    private final TypeNode type = TypeNode.ASSET;
    private STEntry symEntry;


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

        if (!env.isDeclaredInScope(id)) {
            symEntry = new STEntry(env.getNestLevel(), TypeNode.ASSET, env.offset--);
            env.addEntry(id, symEntry);
        }
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
        return "push 0\n";
    }
}
