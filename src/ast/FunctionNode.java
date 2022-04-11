package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionNode implements Node {
    private Node type;
    private String id;
    private ArrayList<Node> declarations;
    private ArrayList<Node> assets;
    private ArrayList<Node> statements;

    public FunctionNode(TypeNode type, String id, ArrayList<Node> declarations, ArrayList<Node> assets, ArrayList<Node> statements) {
        this.type = type;
        this.id = id;
        this.declarations = declarations;
        this.assets = assets;
        this.statements = statements;
    }

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

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (isVariableDeclared(env)) {
            errors.add(SemanticError.duplicateDeclaration(id));
        } else {
            env.addEntry(id, new STEntry(env.getNestLevel(), env.getOffset()));
            env.incNestLevel();
        }
        return errors;
    }
}
