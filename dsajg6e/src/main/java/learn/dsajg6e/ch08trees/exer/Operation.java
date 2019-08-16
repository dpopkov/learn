package learn.dsajg6e.ch08trees.exer;

import java.util.function.IntBinaryOperator;

enum Operation implements Token {
    ADD("+", Integer::sum),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final IntBinaryOperator operator;

    Operation(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int evaluate(Expression first, Expression second) {
        int v1 = first.value();
        int v2 = second.value();
        return operator.applyAsInt(v1, v2);
    }

    public static boolean isOperation(String s) {
        return s.matches("[+\\-*/]");
    }

    public static Operation of(String s) {
        switch (s) {
            case "+": return ADD;
            case "-": return SUBTRACT;
            case "*": return MULTIPLY;
            case "/": return DIVIDE;
            default:
                throw new IllegalArgumentException("Illegal symbol for operation: " + s);
        }
    }

    @Override
    public String toString() {
        return symbol;
    }
}
