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
//        Se il nome della funzione non è dichiarato
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        }

        for (Node e : exp) {
            errors.addAll(e.checkSemantics(env));
        }

//        Se uno o più parametri non sono dichiarati
        for (String myId : ids){
            if (!env.isDeclared(myId)) {
                errors.add(SemanticError.variableNotDeclared(myId));
            }
        }
        return errors;
    }
}