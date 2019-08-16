package learn.dsajg6e.ch08trees.exer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Takes a fully parenthesized arithmetic expression and converts it to a binary expression tree.
 */
public class P0865ConvertToExpressionTree {

    public InfixExpression convert(String expression) {
        Scanner scanner = new Scanner(expression);
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
        return (InfixExpression) stack.pop();
    }

    private static void popTokensThenPushNewInfix(Deque<Token> stack, Token second) {
        Operation operation = (Operation) stack.pop();
        Expression first = (Expression) stack.pop();
        stack.push(new InfixExpression(first, operation, (Expression) second));
    }
}
