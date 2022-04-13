package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FieldNode implements Node {
    private Node type;
    private String id;
    private Node exp;

    public FieldNode(Node type, String id, Node exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        if (env.isDeclaredInScope(id)) {
            errors.add(SemanticError.duplicateDeclaration(id));
        } else {
            env.addEntry(id, new STEntry(env.getNestLevel(), env.getOffset()));
        }

        errors.addAll(exp.checkSemantics(env));
        return errors;
    }
}
