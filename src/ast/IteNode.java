package ast;

import utils.AssetLanLib;
import utils.EffectsEnvironment;
import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public class IteNode implements Node {

    private final Node condition;
    private final ArrayList<Node> ifStatement;
    private ArrayList<Node> elseStatement;

    public IteNode(Node condition, ArrayList<Node> ifStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
    }

    public IteNode(Node condition, ArrayList<Node> ifStatement, ArrayList<Node> elseStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();

        errors.addAll(condition.checkSemantics(env));

        for (Node node : ifStatement) {
            errors.addAll(node.checkSemantics(env));
        }

        if (elseStatement != null) {
            for (Node node : elseStatement) {
                errors.addAll(node.checkSemantics(env));
            }
        }

        return errors;
    }

    public boolean isReturnPresent() {
        for (Node node : ifStatement) {
            if (node instanceof RetNode) {
                return true;
            }
        }
        if (elseStatement != null)
            for (Node node : elseStatement) {
                if (node instanceof RetNode) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public TypeNode typeCheck(Environment env) {

        TypeNode lastIf = TypeNode.VOID;


        if (condition.typeCheck(env) != TypeNode.BOOL) {
            throw new RuntimeException("Type Error - " + "condition in if statement" + " has type different from " + "bool");
        }
        for (Node ifNode : ifStatement) {
            lastIf = ifNode.typeCheck(env);
        }

        if (elseStatement != null) {
            TypeNode lastElse = TypeNode.VOID;
            for (Node elseNode : elseStatement) {
                lastElse = elseNode.typeCheck(env);
            }

            if (lastIf != lastElse) {
                throw new RuntimeException("Type Error - " + "if and else statement" + " have different type");
            }

        }
        return lastIf;
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        EffectsEnvironment sigma1 = env.copy();
        for (Node s : ifStatement) {
            s.checkEffects(sigma1);
        }

        if (elseStatement == null) {
            env.update(EffectsEnvironment.max(env, sigma1));
            return;
        }

        EffectsEnvironment sigma2 = env.copy();
        for (Node s : elseStatement) {
            s.checkEffects(sigma2);
        }

        sigma1 = EffectsEnvironment.max(sigma1, sigma2);
        env.update(sigma1);
    }

    void checkFixedPoint(EffectsEnvironment env, String fName, ArrayList<String> params) {
        EffectsEnvironment sigma1 = env.copy();
        for (Node s : ifStatement) {
            if (s instanceof CallNode c && c.getId().equals(fName)) {
                c.checkFixedPoint(env, params);
                continue;
            }
            s.checkEffects(sigma1);
        }

        if (elseStatement == null) {
            env.update(EffectsEnvironment.max(env, sigma1));
            return;
        }

        EffectsEnvironment sigma2 = env.copy();
        for (Node s : elseStatement) {
            if (s instanceof CallNode c && c.getId().equals(fName)) {
                c.checkFixedPoint(env, params);
                continue;
            }
            s.checkEffects(sigma2);
        }

        sigma1 = EffectsEnvironment.max(sigma1, sigma2);
        env.update(sigma1);
    }

    private String ifStatementString(Environment env) {
        StringBuilder s = new StringBuilder();
        for (Node node : ifStatement) {
            s.append(node.codeGeneration(env));
        }
        return s.toString();
    }

    private String elseStatementString(Environment env) {
        String s = new String();
        for (Node node : elseStatement) {
            s += node.codeGeneration(env);
        }
        return s;
    }

    @Override
    public String codeGeneration(Environment env) {

        int nPopStrings = 0;
        if (ifStatement != null)
            for (Node stm : ifStatement) {
                if (stm.getClass() == PrintNode.class
                        || stm.getClass() == CallNode.class
                        || stm.getClass() == IteNode.class
                        || stm.getClass() == RetNode.class
                ) {
                    nPopStrings++;
                }
            }

        String pushStms = "";
        String popStms = "";
        if (nPopStrings == 0) {
            pushStms += "push 0\n";
        } else {
            for (int i = 1; i < nPopStrings; i++) {
                popStms += "pop\n";
            }
        }

        String ELSE = AssetLanLib.freshLabel();
        String END = AssetLanLib.freshLabel();
        if (elseStatement != null) {
            return condition.codeGeneration(env) +
                    "push 0\n" +
                    "beq " + ELSE + "\n" +
                    ifStatementString(env) +
                    "b " + END + "\n" +
                    ELSE + ":\n" +
                    elseStatementString(env) +
                    END + ":\n" +
                    popStms +
                    pushStms;
        } else {
            return condition.codeGeneration(env) +
                    "push 0\n" +
                    "beq " + END + "\n" +
                    ifStatementString(env) +
                    "b " + END + "\n" +
                    END + ":\n" +
                    popStms +
                    pushStms;
        }


    }

    ArrayList<Node> getStatements() {
        ArrayList<Node> statements = new ArrayList<>();
        statements.addAll(new ArrayList<>(ifStatement));

        if (elseStatement != null)
            statements.addAll(new ArrayList<>(elseStatement));
        return statements;
    }
}