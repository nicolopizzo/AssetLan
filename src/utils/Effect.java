package utils;

public enum Effect {
    RW, BOT, TOP, EMPTY, FULL;

    public Effect rightExp() {
        if (this == BOT || this == TOP) {
            return TOP;
        } else {
            return RW;
        }
    }

    // SX
    public Effect leftExp() {
        if (this == BOT || this == RW) {
            return RW;
        } else {
            return TOP;
        }
    }

    // Move - Somma Astratta
    public Effect assetMax(Effect yEffect) {
        if (this == EMPTY && yEffect == EMPTY) {
            return EMPTY;
        } else {
            return FULL;
        }
    }

    public Effect ifOperator() {
        return this;
    }
}

