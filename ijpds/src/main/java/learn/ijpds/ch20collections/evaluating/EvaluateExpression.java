package learn.ijpds.ch20collections.evaluating;

import learn.csia.utils.CliAppArgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateExpression {

    public static final String MULTIPLICATION_OPERATORS = "*/";
    public static final String BINARY_OPERATORS = "+-" + MULTIPLICATION_OPERATORS;
    public static final String OPERATORS = "()" + BINARY_OPERATORS;

    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter expression");
        String expression = cli.nextLine();
        int result = evaluate(expression);
        System.out.println("Result: " + result);
    }

    public static int evaluate(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String[] tokens = insertBlanks(expression).split(" ");
        for (String token : tokens) {
            if (token.length() == 0) {
                continue;
            }
            char ch = token.charAt(0);
            if (ch == '+' || ch == '-') {
                while (!operatorStack.isEmpty() && isBinaryOperator(operatorStack.peek())) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(ch);
            } else if (isMultOperator(ch)) {
                while (!operatorStack.isEmpty() && isMultOperator(operatorStack.peek())) {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.push(ch);
            } else if (ch == '(') {
                operatorStack.push('(');
            } else if (ch == ')') {
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            } else {
                operandStack.push(Integer.valueOf(token));
            }
        }
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        Integer result = operandStack.pop();
        if (!operandStack.isEmpty()) {
            throw new IllegalStateException("Excessive Operands in stack!");
        }
        return result;
    }

    private static final Map<Character, BiFunction<Integer, Integer, Integer>> ACTIONS = new HashMap<>();
    static {
        ACTIONS.put('+', (x, y) -> x + y);
        ACTIONS.put('-', (x, y) -> x - y);
        ACTIONS.put('*', (x, y) -> x * y);
        ACTIONS.put('/', (x, y) -> x / y);
    }

    private static void processAnOperator(Stack<Integer> operands, Stack<Character> operators) {
        Integer op2 = operands.pop();
        Integer op1 = operands.pop();
        Integer result = ACTIONS.get(operators.pop()).apply(op1, op2);
        operands.push(result);
    }

    private static String insertBlanks(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOperator(ch)) {
                builder.append(" ");
                builder.append(ch);
                builder.append(" ");
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) > -1;
    }

    private static boolean isBinaryOperator(char ch) {
        return BINARY_OPERATORS.indexOf(ch) > -1;
    }

    private static boolean isMultOperator(char ch) {
        return MULTIPLICATION_OPERATORS.indexOf(ch) > -1;
    }
}
