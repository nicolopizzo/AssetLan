package ast;

import utils.Environment;
import utils.Functional;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.List;

public class CallNode implements Node {
    private String id;
    private ArrayList<Node> exp;
    private ArrayList<String> ids;
    private STEntry symEntry;
    private ArrayList<STEntry> assetEntries = new ArrayList<>();

    public CallNode(String id, ArrayList<Node> exp, ArrayList<String> ids) {
        this.id = id;
        this.exp = exp;
        this.ids = ids;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        // Check if the function is defined somewhere
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
        }

        for (Node e : exp) {
            errors.addAll(e.checkSemantics(env));
        }

        // Check if some assets are not declared
        for (String myId : ids) {
            if (!env.isDeclared(myId)) {
                errors.add(SemanticError.variableNotDeclared(myId));
            } else {
                assetEntries.add(env.getLastEntry(myId));
            }
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        List<TypeNode> paramsType = Environment.getParamsType(symEntry);

        ArrayList<TypeNode> givenParams = new ArrayList<>();
        givenParams.addAll(Functional.mapList(exp, e -> e.typeCheck(env)));
        givenParams.addAll(Functional.mapList(ids, id -> env.getType(id)));

        if (paramsType.size() != givenParams.size()) {
            // TODO: handle type errors
            throw new RuntimeException("Type error: wrong number of parameters");
        }

        for (int i = 0; i < paramsType.size(); i++){
            TypeNode t1 = paramsType.get(i);
            TypeNode t2 = givenParams.get(i);

            if (t1 != t2) {
                // TODO: handle type errors
                throw new RuntimeException("Type error: wrong type of parameter (" + t1 + " != " + t2 + ")");
            }
        }

        applyEffect();
        return env.getType(id);
    }

    @Override
    public void checkEffects(Environment env) {

    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }

    private void applyEffect() {
     //  assetEntries.forEach(stEntry -> stEntry.empty());
    }
}