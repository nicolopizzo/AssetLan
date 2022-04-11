package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class CallNode implements Node{

    private String id;
    private ArrayList<Node> exp;
    private ArrayList<String> ids;

    private boolean isVariableDeclared(Environment env, String id) {
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

    public CallNode(String id, ArrayList<Node> exp, ArrayList<String> ids) {
        this.id = id;
        this.exp = exp;
        this.ids = ids;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!isVariableDeclared(env, id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        }
        for (String myId : ids){
            if (!isVariableDeclared(env, myId)) {
                errors.add(SemanticError.variableNotDeclared(myId));
            }
        }
        return errors;
    }
}