package ast;

import utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InitCallNode implements Node {
    private String id;
    private ArrayList<Node> params;
    private ArrayList<Node> assets;
    private STEntry symEntry;
    private int nestinglevel;

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
            nestinglevel = env.getNestLevel();
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

        List<TypeNode> toCompare = Environment.getParamsType(symEntry);

        ArrayList<TypeNode> paramsTypes = new ArrayList<>();
        paramsTypes.addAll(Functional.mapList(params, p -> p.typeCheck(env)));
        paramsTypes.addAll(Functional.mapList(assets, a -> a.typeCheck(env)));

        if (toCompare.size() != paramsTypes.size()) {
            throw new RuntimeException("Type error: wrong number of parameters");
        }

        for (int i = 0; i < toCompare.size(); i++){
            TypeNode t1 = toCompare.get(i);
            TypeNode t2 = paramsTypes.get(i);

            if (t1 == TypeNode.ASSET && (t2 == TypeNode.ASSET || t2 == TypeNode.INT)) {
                continue;
            }

            if (t1 != t2) {
                throw new RuntimeException("Type error: wrong type of parameter (" + t1 + " != " + t2 + ")");
            }
        }

        return env.getType(id);
    }

    @Override
    public void checkEffects(EffectsEnvironment env) {
        FunctionEffect effect = (FunctionEffect) env.getEffect(id);
        EffectsEnvironment sigma1 = effect.getSigma1();
        ArrayList<String> localAssets = effect.getLocalAssets();
        ArrayList<String> globalAssets = effect.getGlobalAssets();

        HashMap<String, AssetEffect> replaceMap = new HashMap<>();

        for (int i = 0; i < assets.size(); i++) {
            Node a = assets.get(i);
            String id = localAssets.get(i);

            int value = 0;
            if (a instanceof BinExpNode b) {
                value = b.getValue();
            } else if (a instanceof ValExpNode v) {
                value = v.getValue();
            } else if (a instanceof BaseExpNode b) {
                value = b.getValue();
            }

            if (value > 0) {
                replaceMap.put(id, AssetEffect.Full());
            } else if (value == 0) {
                replaceMap.put(id, AssetEffect.Empty());
            } else  {
                System.out.println("Error: negative asset value in initCall");
                System.exit(1);
            }

        }



        for (String a : localAssets) {
            Effect e = sigma1.getEffect(a);
            if (e instanceof AssetEffect ae && !ae.isEmpty()) {
                System.out.println("Error: formal asset " + a + " is not empty. The function " + id + " is not liquid.");
                System.exit(1);
            } else if (e instanceof NormalFormEffect ne) {
                AssetEffect ae = ne.resolve(replaceMap);

                if (!ae.isEmpty()) {
                    System.out.println("Error: formal asset " + a + " is in normal form. The function " + id + " is not liquid.");
                    System.exit(1);
                }
            }
        }

        // Controllo che in sigma1 gli asset parametro siano a 0
        for (String a : globalAssets) {
            Effect e = sigma1.getEffect(a);
            if (e instanceof AssetEffect ae && !ae.isEmpty()) {
                System.out.println("Error: asset " + a + " is not empty. Program is not liquid.");
                System.exit(1);
            } else if (e instanceof NormalFormEffect ne) {
                if (!ne.isSingleton() || !ne.hasAsset(a)) {
                    System.out.println("Error: formal asset " + a + " is in normal form. Program is not liquid.");
                    System.exit(1);
                }
            }
        }
    }

    @Override
    public String codeGeneration(Environment env) {
        String parCode="";
        for (int i=params.size()-1; i>=0; i--)
            parCode+=params.get(i).codeGeneration(env);

        String aparCode="";
        for (int i=assets.size()-1; i>=0; i--)
            aparCode+=assets.get(i).codeGeneration(env);

        String getAR="";
        for (int i=0; i<nestinglevel-symEntry.getNestLevel(); i++)
            getAR+="lw\n";

        return "lfp\n"+
                aparCode+
                parCode+
                "lfp\n"+
                getAR+ 		// setto AL risalendo la catena statica
                // ora recupero l'indirizzo a cui saltare e lo metto sullo stack
                "push "+symEntry.getOffset()+"\n"+ // metto offset sullo stack
                "lfp\n"+
                getAR+ 		// risalgo la catena statica
                "add\n"+
                "lw\n"+ 				// carico sullo stack il valore all'indirizzo ottenuto
                "js\n";
    }
}
