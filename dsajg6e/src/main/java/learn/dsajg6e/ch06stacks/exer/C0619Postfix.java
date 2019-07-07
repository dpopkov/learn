package learn.dsajg6e.ch06stacks.exer;

import learn.dsajg6e.ch06stacks.LinkedStack;
import learn.dsajg6e.ch06stacks.Stack;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class C0619Postfix {
    private static final Predicate<String> NUMBER_PREDICATE = Pattern.compile("\\d+").asMatchPredicate();

    public int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Integer> stack = new LinkedStack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int o2 = stack.pop();
                int o1 = stack.pop();
                stack.push(calculate(o1, o2, token));
            }
        }
        return stack.pop();
    }

    private int calculate(int x, int y, String operation) {
        switch (operation) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
            default: throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private static boolean isNumber(String s) {
        return NUMBER_PREDICATE.test(s);
    }
}
