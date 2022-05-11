package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FunctionNode implements Node {
    private final TypeNode type;
    private final String id;
    private final ArrayList<Node> declarations;
    private final ArrayList<Node> assets;
    private final ArrayList<Node> fields;
    private final ArrayList<Node> statements;

    public FunctionNode(TypeNode type, String id, ArrayList<Node> declarations, ArrayList<Node> assets, ArrayList<Node> fields, ArrayList<Node> statements) {
        this.type = type;
        this.id = id;
        this.declarations = declarations;
        this.assets = assets;
        this.fields = fields;
        this.statements = statements;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        if (env.isDeclaredInScope(id)) {
            errors.add(SemanticError.duplicateDeclaration(id));
            return errors;
        }

        ArrayList<TypeNode> types = new ArrayList<>();
        for (Node declaration : declarations) {
            types.add(((ParamNode) declaration).getType());
        }
        for (int i = 0; i < assets.size(); i++) {
            types.add(TypeNode.ASSET);
        }
        types.add(type);


        env.addEntry(id, new STEntry(env.getNestLevel(), types, env.getOffset()));

        env.enterScope();
        for (Node d : declarations) {
            errors.addAll(d.checkSemantics(env));
        }
        for (Node a : assets) {
            errors.addAll(a.checkSemantics(env));
        }
        for (Node f : fields) {
            errors.addAll(f.checkSemantics(env));
        }
        for (Node s : statements) {
            errors.addAll(s.checkSemantics(env));
        }
        env.exitScope();

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        //ArrayList<SemanticError> errors = new ArrayList<>();

        for (Node d : declarations) {
            d.typeCheck(env);
        }
        for (Node a : assets) {
            a.typeCheck(env);
        }
        for (Node f : fields) {
            f.typeCheck(env);
        }

        for (Node s : statements) {
            TypeNode t1 = s.typeCheck(env);

            // Se il nodo a runtime è di tipo ReturnNode verifico che il tipo restituito sia corretto
            // TODO: refactoring per return dentro ITE.
            if ((s instanceof IteNode) && ((IteNode) s).hasReturnNode()) {
                if (type != t1) {
                    //errors.add(SemanticError.typeError(id, "function return type"));
                    throw new RuntimeException("Type Error - " + id + " has type different from " + "function return type");
                }
            }
            if (s instanceof RetNode) {
                if (type != t1) {
                    //errors.add(SemanticError.typeError(id, "function return type"));
                    throw new RuntimeException("Type Error - " + id + " has type different from " + "function return type");
                }
            }
        }


        return TypeNode.NULL;
    }
}
