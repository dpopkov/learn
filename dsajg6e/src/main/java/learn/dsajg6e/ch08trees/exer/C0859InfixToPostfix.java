package learn.dsajg6e.ch08trees.exer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Converter of infix arithmetic expressions to equivalent postfix notation.
 * All tokens must be separated with spaces.
 */
public class C0859InfixToPostfix {
    public String infixToPostfix(String infix) {
        Scanner scanner = new Scanner(infix);
        Deque<Token> stack = new LinkedList<>();
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (RoundBracket.OPENING.equals(token)) {
                stack.push(new RoundBracket(token));
            } else if (RoundBracket.CLOSING.equals(token)) {
                Token infixExpr = stack.pop();
                Token t = stack.pop();
                if (t instanceof RoundBracket && ((RoundBracket) t).isOpening()) {
                    if (stack.isEmpty()) {
                        stack.push(infixExpr);
                    } else {
                        popTokensThenPushNewInfix(stack, infixExpr);
                    }
                } else {
                    stack.push(infixExpr);
                }
            } else if (Number.isNumber(token)) {
                Number number = new Number(token);
                if (stack.isEmpty()) {
                    stack.push(number);
                } else {
                    if (stack.peek() instanceof Operation) {
                        popTokensThenPushNewInfix(stack, number);
                    } else {
                        stack.push(number);
                    }
                }
            } else if (Operation.isOperation(token)) {
                stack.push(Operation.of(token));
            }
        }
        if (stack.size() > 1) {
            while (true) {
                Token t = stack.pop();
                if (t instanceof Expression) {
                    popTokensThenPushNewInfix(stack, t);
                    if (stack.size() == 1) {
                        break;
                    }
                } else {
                    throw new IllegalStateException("This token must be Expression, but it is not: " + t);
                }
            }
        }
        return stack.pop().toString();
    }

    private static void popTokensThenPushNewInfix(Deque<Token> stack, Token second) {
        Operation operation = (Operation) stack.pop();
        Expression first = (Expression) stack.pop();
        stack.push(new Infix(first, operation, (Expression) second));
    }

    interface Token {}

    private static class RoundBracket implements Token {
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

    private enum Operation implements Token {
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

    private static class Infix implements Expression {
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

    private static class Number implements Expression {
        private static final Pattern numberPattern = Pattern.compile("\\d+");

        private final int value;

        public Number(String value) {
            this(Integer.parseInt(value));
        }

        public Number(int value) {
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
