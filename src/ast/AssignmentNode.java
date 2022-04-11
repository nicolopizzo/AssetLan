package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentNode implements Node{
    private String id;
    private Node exp;

    public boolean isVariableDeclared(Environment env) {
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

    public AssignmentNode(String id, Node exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!isVariableDeclared(env)) {
            errors.add(SemanticError.variableNotDeclared(id));
        }
        return errors;
    }
}