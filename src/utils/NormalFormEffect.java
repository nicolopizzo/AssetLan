package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class NormalFormEffect extends Effect {
    private ArrayList<String> assets = new ArrayList<>();

    public NormalFormEffect() {
    }

    public NormalFormEffect(String asset) {
        this.assets.add(asset);
    }

    public static NormalFormEffect max(NormalFormEffect n1, NormalFormEffect n2) {
        NormalFormEffect n = new NormalFormEffect();
        n.assets.addAll(n1.assets);

        for (String asset : n2.assets) {
            if (!n.assets.contains(asset))
                n.assets.add(asset);
        }

        return n;
    }

    public AssetEffect resolve(HashMap<String, AssetEffect> hm) {
        hm.put("0", AssetEffect.Empty());

        AssetEffect ae = AssetEffect.Empty();
        for (String asset : assets) {
            if (!hm.containsKey(asset)) {
                System.out.println("Error: asset " + asset + " not declared");
                System.exit(1);
            }

            ae = AssetEffect.max(ae, hm.get(asset));
        }

        return ae;
    }
}
