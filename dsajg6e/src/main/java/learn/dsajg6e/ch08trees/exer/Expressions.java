package learn.dsajg6e.ch08trees.exer;

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
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
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

        @Override
        public String toString() {
            return toStringPostfix();
        }

        @Override
        public int value() {
            throw new UnsupportedOperationException("Not implemented");
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

        static boolean isNumber(String s) {
            return numberPattern.matcher(s).matches();
        }
    }
}
