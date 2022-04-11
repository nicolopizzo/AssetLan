package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

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

    private boolean isVariableDeclared(Environment env) {
        HashMap<String, ArrayList<STEntry>> symTable = env.getSymTable();
        ArrayList<STEntry> listOfLevels = symTable.get(id);
        if (symTable.containsKey(id)) {
            for (STEntry l : listOfLevels) {
                if (l.getNestLevel() == env.getNestLevel()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!isVariableDeclared(env)) {
            env.addEntry(id, new STEntry(env.getNestLevel(), env.getOffset()));
        } else {
            errors.add(SemanticError.duplicateError(id));
        }
        return errors;
    }
}
