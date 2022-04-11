package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FieldNode implements Node {
    private TypeNode type;
    private String id;
    private ExpNode exp;

    public FieldNode(TypeNode type, String id, ExpNode exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    public TypeNode getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public ExpNode getExp() {
        return exp;
    }

//    TODO: inserire la logica della checksemantics in una funzione separata; in questo caso se non è dichiarata la var.

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        try {
            env.addEntry(id, new STEntry(env.getNestLevel(), env.getOffset()));
        } catch (Exception e) {
            errors.add(new SemanticError(e.getMessage()));
        } finally {
            return errors;
        }
    }
}
