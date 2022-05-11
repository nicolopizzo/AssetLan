package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class ParamNode implements Node {
    private TypeNode type;
    private String id;

    public ParamNode(TypeNode type, String id) {
        this.type = type;
        this.id = id;
    }

    public TypeNode getType() {
        return type;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (env.isDeclaredInScope(id)) {
            errors.add(SemanticError.duplicateDeclaration(id));
        } else {
            env.addEntry(id, new STEntry(env.getNestLevel(), type, env.getOffset()));
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env){
        return TypeNode.NULL;
    }
}
