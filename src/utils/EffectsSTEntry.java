package utils;

/*enum Effect {
    RW, BOT, TOP, EMPTY, FULL
}*/

public class EffectsSTEntry {
    private int nestLevel;
    private Effect effect;

    public EffectsSTEntry(int nestLevel, Effect effect) {
        this.nestLevel = nestLevel;
        this.effect = effect;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setNestLevel(int nestLevel) {
        this.nestLevel = nestLevel;
    }

}
