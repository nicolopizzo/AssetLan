package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class AssignmentNode implements Node{
    private String id;
    private Node exp;


    public AssignmentNode(String id, Node exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        }

        errors.addAll(exp.checkSemantics(env));
        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode idType = env.getType(id);

        //ArrayList<SemanticError> errors = new ArrayList<>();
        if (idType != exp.typeCheck(env)){
            //errors.add(SemanticError.typeError(id, "right expression"));
            throw new RuntimeException("Type Error - " + id + " has type different from " + "right expression");
        }

        return TypeNode.NULL;
    }
}