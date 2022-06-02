package ast;

import utils.Environment;
import utils.Functional;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.List;

public class InitCallNode implements Node {
    private String id;
    private ArrayList<Node> params;
    private ArrayList<Node> assets;
    private STEntry symEntry;

    public InitCallNode(String id, ArrayList<Node> params, ArrayList<Node> assets) {
        this.id = id;
        this.params = params;
        this.assets = assets;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (!env.isDeclared(id)) {
            errors.add(SemanticError.variableNotDeclared(id));
        } else {
            symEntry = env.getLastEntry(id);
        }
        for (Node param : params) {
            errors.addAll(param.checkSemantics(env));
        }
        for (Node asset : assets) {
            errors.addAll(asset.checkSemantics(env));
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        // TODO: check the given parameters correspond to the ones in the definition of the function.
        List<TypeNode> toCompare = Environment.getParamsType(symEntry);

        ArrayList<TypeNode> paramsTypes = new ArrayList<>();
        paramsTypes.addAll(Functional.mapList(params, p -> p.typeCheck(env)));
        paramsTypes.addAll(Functional.mapList(assets, a -> a.typeCheck(env)));

        if (toCompare.size() != paramsTypes.size()) {
            // TODO: handle type errors
            throw new RuntimeException("Type error: wrong number of parameters");
        }

        for (int i = 0; i < toCompare.size(); i++){
            TypeNode t1 = toCompare.get(i);
            TypeNode t2 = paramsTypes.get(i);

            if (t1 == TypeNode.ASSET && (t2 == TypeNode.ASSET || t2 == TypeNode.INT)) {
                System.out.println("Bubu");
                continue;
            }

            if (t1 != t2) {
                // TODO: handle type errors
                throw new RuntimeException("Type error: wrong type of parameter (" + t1 + " != " + t2 + ")");
            }
        }

        return env.getType(id);
    }

    @Override
    public void checkEffects(Environment env) {

    }

    @Override
    public String codeGeneration(Environment env) {
        return null;
    }
}
