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
        // TOOD: handle effects, check liquidity, check everything under top
    }

    private String fieldsString(Environment env) {
        StringBuilder fieldCode = new StringBuilder();
        for (Node node : fields) {
            fieldCode.append(node.codeGeneration(env));
        }

        return fieldCode.toString();
    }

    private String functionsString(Environment env) {
        StringBuilder functionsCode = new StringBuilder();
        for (Node node : functions) {
            functionsCode.append(node.codeGeneration(env));
        }

        return functionsCode.toString();
    }

    @Override
    public String codeGeneration(Environment env) {
        return "push 0\n"+
                fieldsString(env)+
                functionsString(env)+
                initCall.codeGeneration(env)+
                "halt\n"+
                AssetLanLib.getCode();
    }
}
