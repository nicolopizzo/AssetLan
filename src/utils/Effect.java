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

    public Effect ifOperator(Effect e) {
        if (this == BOT && (e == BOT || e == RW)) {
            return BOT;
        } else if (this == RW && e == RW) {
            return RW;
        }

        return TOP;
    }

    public static Effect max(Effect e1, Effect e2) {
        if (e1 == EMPTY) {
            return e2;
        }

        return e1;
    }
}

