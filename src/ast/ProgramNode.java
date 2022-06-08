package ast;

import utils.AssetLanLib;
import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;


public class ProgramNode implements Node {
    private ArrayList<Node> fields;
    private ArrayList<Node> assets;
    private ArrayList<Node> functions;
    private ArrayList<STEntry> entries = new ArrayList<>();
    private Node initCall;

    public ProgramNode(ArrayList<Node> fields, ArrayList<Node> assets, ArrayList<Node> functions, Node initCall) {
        this.fields = fields;
        this.assets = assets;
        this.functions = functions;
        this.initCall = initCall;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        for (Node f : fields) {
            errors.addAll(f.checkSemantics(env));
        }

        for (Node a : assets) {
            errors.addAll(a.checkSemantics(env));
            entries.add(env.getLastEntry(((AssetNode) a).getId()));
        }

        for (Node f : functions) {
            errors.addAll(f.checkSemantics(env));
        }

        errors.addAll(initCall.checkSemantics(env));

        return errors;
    }

    @Override
    public TypeNode typeCheck(Environment env) {
        for (Node f : fields) {
            f.typeCheck(env);
        }

        for (Node a : assets) {
            a.typeCheck(env);
        }

        for (Node f : functions) {
            f.typeCheck(env);
        }

        initCall.typeCheck(env);

        return TypeNode.VOID;
    }

    @Override
    public void checkEffects(Environment env) {
        // TODO: handle effects, check liquidity, check everything under top
    }

    @Override
    public String codeGeneration(Environment env) {
        String fieldsCode="";
        for (Node field:fields)
            fieldsCode+=field.codeGeneration(env);

        String fundecsCode="";
        for (Node fundec:functions)
            fundecsCode+=fundec.codeGeneration(env);

        return "push 0\n"+
                fieldsCode+
                fundecsCode+
                initCall.codeGeneration(env)+
                "halt\n"+
                AssetLanLib.getCode();
    }
}
