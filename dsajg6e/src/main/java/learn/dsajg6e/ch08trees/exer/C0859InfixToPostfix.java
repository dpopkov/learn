package learn.dsajg6e.ch08trees.exer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

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
            } else if (IntNumber.isNumber(token)) {
                IntNumber number = new IntNumber(token);
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
        stack.push(new InfixExpression(first, operation, (Expression) second));
    }
}
