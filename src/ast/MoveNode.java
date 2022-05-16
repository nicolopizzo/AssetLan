package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class MoveNode implements Node {

    private String id1;
    private String id2;

    private STEntry entry1;
    private STEntry entry2;

    public MoveNode(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclared(id2)) {
            semanticErrors.add(SemanticError.variableNotDeclared(id2));
        } else {
            entry2 = env.getLastEntry(id2);
        }

        if (!env.isDeclared(id1)) {
            semanticErrors.add(SemanticError.variableNotDeclared(id1));
        } else {
            entry1 = env.getLastEntry(id1);
        }

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode t1 = entry1.getTypes().get(0);
        TypeNode t2 = entry2.getTypes().get(0);

        //ArrayList<SemanticError> errors = new ArrayList<>();
        if (t1 != TypeNode.ASSET || t2 != TypeNode.ASSET) {
            //errors.add(SemanticError.typeError(id1, id2));
            throw new RuntimeException("Type Error - " + id1 + " has type different from " + id2);
        }

        applyEffect();

        return TypeNode.NULL;
    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }

    private void applyEffect() {
        if (entry1.isFilled() || entry2.isFilled()) {
            entry2.fill();
            System.out.println(entry2 + " -> " + id2 + ". Filled = " + entry2.isFilled());
        }

        entry1.empty();
    }
}