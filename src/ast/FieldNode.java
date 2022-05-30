package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FieldNode implements Node {
    private TypeNode type;
    private String id;
    private Node exp;

    public FieldNode(TypeNode type, String id, Node exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    public FieldNode(TypeNode type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        if (env.isDeclaredInScope(id)) {
            errors.add(SemanticError.duplicateDeclaration(id));
        } else {
            env.addEntry(id, new STEntry(env.getNestLevel(), type, env.getOffset()));
        }

        if (exp != null) {
            errors.addAll(exp.checkSemantics(env));
        }
        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env){

        //ArrayList<SemanticError> errors = new ArrayList<>();
        if (exp != null) {
            if (type != exp.typeCheck(env)) {
                //errors.add(SemanticError.typeError(id, "right expression"));
                throw new RuntimeException("Type Error - " + id + " has type different from " + "right expression");
            }
        }
        return TypeNode.NULL;
    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}
