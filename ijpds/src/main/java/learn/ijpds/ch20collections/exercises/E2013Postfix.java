package learn.ijpds.ch20collections.exercises;

import learn.csia.utils.CliAppArgs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class E2013Postfix {
    private Map<String, BiFunction<Integer, Integer, Integer>> operators;

    E2013Postfix() {
        operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);
    }

    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operators.get(token).apply(operand1, operand2));
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter postfix expression");
        String expression = cli.nextLine();
        int result = new E2013Postfix().evaluate(expression);
        System.out.println("result = " + result);
    }
}
