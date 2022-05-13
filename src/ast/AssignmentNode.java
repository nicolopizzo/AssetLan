package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class AssignmentNode implements Node {
    private String id;
    private Node exp;
    private STEntry symEntry;


    public AssignmentNode(String id, Node exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
        }

        errors.addAll(exp.checkSemantics(env));
        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        TypeNode idType = Environment.getType(symEntry);
        TypeNode expType = exp.typeCheck(env);

        if (idType == TypeNode.INT && expType == TypeNode.BOOL) {
            throw new RuntimeException("Type Error: " + id + " has type " + idType + ", right expression has type " + expType);
        } else if (idType != TypeNode.INT && idType != expType) {
            throw new RuntimeException("Type Error: " + id + " has type " + idType + ", right expression has type " + expType);
        }

        return TypeNode.NULL;
    }
}