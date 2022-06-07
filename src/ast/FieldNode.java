package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;

public class FieldNode implements Node {
    private TypeNode type;
    private String id;
    private Node exp;
    private STEntry symEntry;

    public FieldNode(TypeNode type, String id, Node exp) {
        this.type = type;
        this.id = id;
        this.exp = exp;
    }

    public FieldNode(TypeNode type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        if (exp != null) {
            errors.addAll(exp.checkSemantics(env));
        }

        if (env.isDeclaredInScope(id)) {
            errors.add(SemanticError.duplicateDeclaration(id));
        } else {

            symEntry = new STEntry(env.getNestLevel(), type, env.getOffset());
            env.addEntry(id, symEntry);
        }

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {

        if(type == TypeNode.VOID) {
            throw new RuntimeException("Field cannot be of type void");
        }

        if (exp != null) {
            if (type == TypeNode.INT || type == TypeNode.ASSET) {
                if (exp.typeCheck(env) != TypeNode.ASSET && exp.typeCheck(env) != TypeNode.INT)
                    throw new RuntimeException("Type Error - " + id + " has type different from " + "right expression");
            }

            if (type == TypeNode.BOOL) {
                if (exp.typeCheck(env) != TypeNode.BOOL)
                    throw new RuntimeException("Type Error - " + id + " has type different from " + "right expression");
            }
        }
        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(Environment env) {

    }

    @Override
    public String codeGeneration(Environment env) {
        if (exp != null) {
            return exp.codeGeneration(env);
                    /*
                    +
                    "push "+symEntry.getOffset()+"\n"+
                    "sw\n";
                     */
        } else {
            return "";
        }
    }

}