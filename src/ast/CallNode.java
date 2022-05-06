package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class CallNode implements Node {

    private String id;
    private ArrayList<Node> exp;
    private ArrayList<String> ids;

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
        }

        for (Node e : exp) {
            errors.addAll(e.checkSemantics(env));
        }

        // Check if some assets are not declared
        for (String myId : ids) {
            if (!env.isDeclared(myId)) {
                errors.add(SemanticError.variableNotDeclared(myId));
            }
        }
        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        // TODO: check the given parameters correspond to the ones in the definition of the function.
        ArrayList<TypeNode> paramsType = env.getParamsType(id);

        for (int i = 0; i < paramsType.size(); i++){
            TypeNode t1 = paramsType.get(i);
            TypeNode t2 = exp.get(i).typeCheck(env);

            if (t1 != t2) {
            // TODO: handle type errors

            }
        }

        return env.getType(id);
    }
}