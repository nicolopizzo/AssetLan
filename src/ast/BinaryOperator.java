package ast;

//enum used to manage the exp operator
public enum BinaryOperator {
    ADD, SUB, MUL, DIV, AND, OR, EQ, NE, LT, GT, LE, GE;

    static BinaryOperator fromString(String s) {
        return switch (s) {
            case "+" -> ADD;
            case "-" -> SUB;
            case "*" -> MUL;
            case "/" -> DIV;
            case "&&" -> AND;
            case "||" -> OR;
            case "==" -> EQ;
            case "!=" -> NE;
            case "<" -> LT;
            case ">" -> GT;
            case "<=" -> LE;
            case ">=" -> GE;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case ADD -> "+";
            case SUB -> "-";
            case MUL -> "*";
            case DIV -> "/";
            case AND -> "&&";
            case OR -> "||";
            case EQ -> "==";
            case NE -> "!=";
            case LT -> "<";
            case GT -> ">";
            case LE -> "<=";
            case GE -> ">=";
            default -> "";
        };
    }

    //methods called in typeCheck()
    public boolean isArithmetic() {
        return this == ADD || this == SUB || this == MUL || this == DIV;
    }

    public boolean isLogical() {
        return this == AND || this == OR;
    }

    public boolean isRelational() {
        return this == LT || this == GT || this == LE || this == GE;
    }

    public boolean isEquality() {
        return this == EQ || this == NE;
    }

}
