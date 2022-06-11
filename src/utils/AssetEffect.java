package utils;

public class AssetEffect extends Effect {
    private int effect;

    private AssetEffect(int effect) {
        this.effect = effect;
    }

    public static AssetEffect Empty() {
        return new AssetEffect(0);
    }

    public static AssetEffect Full() {
        return new AssetEffect(1);
    }

    public static AssetEffect max(AssetEffect e1, AssetEffect e2) {
        if (e1.effect == 0) {
            return e2;
        }

        return e1;
    }

    public boolean isEmpty() {
        return effect == 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AssetEffect e && effect == e.effect;
    }
}
