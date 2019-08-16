package learn.dsajg6e.ch08trees.exer;

import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;

public class Expressions {
    interface Token {}

    static class RoundBracket implements Token {
        static final String OPENING = "(";
        static final String CLOSING = ")";

        private boolean opening;
        private final String symbol;

        public RoundBracket(String s) {
            symbol = s;
            if (OPENING.equals(s)) {
                opening = true;
            } else if (CLOSING.equals(s)) {
                opening = false;
            } else {
                throw new IllegalArgumentException("Invalid symbol for round bracket: " + s);
            }
        }

        public boolean isOpening() {
            return opening;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    interface Expression extends Token {
        @SuppressWarnings("unused")
        int value();
    }

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

    static class Infix implements Expression {
        private final Expression first;
        private final Expression second;
        private final Operation operation;

        public Infix(Expression first, Operation operation, Expression second) {
            this.first = first;
            this.second = second;
            this.operation = operation;
        }

        public String toStringPostfix() {
            return first + " " + second + " " + operation;
        }

        public Expression getFirst() {
            return first;
        }

        public Expression getSecond() {
            return second;
        }

        public Operation getOperation() {
            return operation;
        }

        @Override
        public String toString() {
            return toStringPostfix();
        }

        @Override
        public int value() {
            return operation.evaluate(first, second);
        }
    }

    static class IntNumber implements Expression {
        private static final Pattern numberPattern = Pattern.compile("\\d+");

        private final int value;

        public IntNumber(String value) {
            this(Integer.parseInt(value));
        }

        public IntNumber(int value) {
            this.value = value;
        }

        @Override
        public int value() {
            return value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            return value == ((IntNumber) other).value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        static boolean isNumber(String s) {
            return numberPattern.matcher(s).matches();
        }
    }
}
