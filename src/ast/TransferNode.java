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
        if (env.getType(id) != TypeNode.ASSET){
            //System.out.println("Error: " + id + " is not an asset");
            throw new RuntimeException("Type Error - " + id + " has type different from " + "ASSET");
        }
        applyEffect();
        return TypeNode.VOID;
    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }

    private void applyEffect() {
        entry.empty();
    }
}