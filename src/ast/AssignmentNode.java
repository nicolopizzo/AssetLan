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
        if (env.isEntityDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        }
        return errors;
    }
}