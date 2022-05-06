package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FunctionNode implements Node {
    private TypeNode type;
    private String id;
    private ArrayList<Node> declarations;
    private ArrayList<Node> assets;
    private ArrayList<Node> fields;
    private ArrayList<Node> statements;

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
        env.addEntry(id, new STEntry(env.getNestLevel(), type, env.getOffset()));

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
        ArrayList<SemanticError> errors = new ArrayList<>();

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
            if((s instanceof IteNode) && ((IteNode) s).hasReturnNode()) {
                if (type != t1) {
                    errors.add(SemanticError.typeError(id, "function return type"));
                }
            }

            /*
            * int f()[] {
            *   if (c) {
            *       g() //bool
            *   }
            *
            *   return 2;
            * }
            *
            * */

            if(s instanceof RetNode){
                if(type != t1){
                    errors.add(SemanticError.typeError(id, "function return type"));
                }
            }
        }


        return TypeNode.NULL;
    }
}
