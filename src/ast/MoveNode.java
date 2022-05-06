package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class MoveNode implements Node {

    private String id1;
    private String id2;

    public MoveNode(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isDeclared(id1)) {
            semanticErrors.add(SemanticError.variableNotDeclared(id1));
        }

        if (!env.isDeclared(id2)) {
            semanticErrors.add(SemanticError.variableNotDeclared(id2));
        }

        return semanticErrors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode t1 = env.getType(id1);
        TypeNode t2 = env.getType(id2);

        ArrayList<SemanticError> errors = new ArrayList<>();
        if (t1 != t2){
            errors.add(SemanticError.typeError(id1, id2));
        }
        return TypeNode.NULL;
    }
}