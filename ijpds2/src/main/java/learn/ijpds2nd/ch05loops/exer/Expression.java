package learn.ijpds2nd.ch05loops.exer;

import java.util.function.IntBinaryOperator;

public class Expression {
    private final int o1;
    private final int o2;
    private final Operation operation;

    enum Operation implements IntBinaryOperator {
        ADD(Integer::sum, "+"),
        MULTIPLY((x, y) -> x * y, "*")
        ;
        private final IntBinaryOperator operation;
        private final String symbol;

        Operation(IntBinaryOperator operation, String symbol) {
            this.operation = operation;
            this.symbol = symbol;
        }

        @Override
        public int applyAsInt(int left, int right) {
            return operation.applyAsInt(left, right);
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public int o1() {
        return o1;
    }

    public int o2() {
        return o2;
    }

    private Expression(int o1, int o2, Operation operation) {
        this.o1 = o1;
        this.o2 = o2;
        this.operation = operation;
    }

    public boolean isProducing(int result) {
        return result() == result;
    }

    public static Expression generate(Operation operation, int upperLimit) {
        int v1 = (int) (Math.random() * upperLimit);
        int v2 = (int) (Math.random() * upperLimit);
        if (v1 < v2) {
            int temp = v1;
            v1 = v2;
            v2 = temp;
        }
        return new Expression(v1, v2, operation);
    }

    public int result() {
        return operation.applyAsInt(o1, o2);
    }

    @Override
    public String toString() {
        return o1 + operation.getSymbol() + o2 + " = ";
    }
}
