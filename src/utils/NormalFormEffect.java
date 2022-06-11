package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

    public void replace(NormalFormEffect e) {
        this.assets.clear();
        this.assets.addAll(e.assets);
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

    public void replace(HashMap<String, Effect> hm) {
        hm.put("0", AssetEffect.Empty());
        HashSet<String> replacedAssets = new HashSet<>();
        for (int i = 0; i < assets.size(); i++) {
            String asset = assets.get(i);
            if (hm.containsKey(asset) && !replacedAssets.contains(asset)) {
                if (hm.get(asset) instanceof NormalFormEffect n) {
                    assets.remove(i);
                    assets.addAll(n.assets);
                    replacedAssets.add(asset);
//                    assets.set(i, n.assets.get(0));
                }

//                assets.set(i, hm.get(asset).toString());
            }
        }
    }

    public boolean isEmpty() {
        return assets.size() == 1 && assets.get(0).equals("0");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NormalFormEffect n && assets.equals(n.assets);
    }

    public boolean isSingleton() {
        return assets.size() == 1;
    }

    public boolean hasAsset(String asset) {
        return assets.contains(asset);
    }
}
