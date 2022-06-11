package utils;

/*enum Effect {
    RW, BOT, TOP, EMPTY, FULL
}*/

public class EffectsSTEntry {
    private int nestLevel;
    private Effect effect;

    public EffectsSTEntry(Effect effect, int nestLevel) {
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public EffectsSTEntry copy() {
        return new EffectsSTEntry(effect, nestLevel);
    }

    // equals() method

    @Override
    public boolean equals(Object o) {
        return o instanceof EffectsSTEntry e
                && nestLevel == e.nestLevel
                && effect.equals(e.effect);
    }
}
