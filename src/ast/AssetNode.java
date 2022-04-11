package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class AssetNode implements Node {
    private String id;

    public AssetNode(String id) {
        this.id = id;
    }

    private boolean isVariableDeclared(Environment env) {
        HashMap<String, ArrayList<STEntry>> symTable = env.getSymTable();
        ArrayList<STEntry> listOfLevels = symTable.get(id);

        for (STEntry l : listOfLevels) {
            if (l.getNestLevel() == env.getNestLevel()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!isVariableDeclared(env)) {
            env.addEntry(id, new STEntry(env.getNestLevel(), env.getOffset()));
        } else {
            semanticErrors.add(SemanticError.duplicateDeclaration(id));
        }

        return semanticErrors;
    }
}
