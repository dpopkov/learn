package learn.dsajg6e.ch08trees.exer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Takes a fully parenthesized arithmetic expression and converts it to a binary expression tree.
 */
public class P0865ConvertToExpressionTree {

    public Expressions.Infix convert(String expression) {
        Scanner scanner = new Scanner(expression);
        Deque<Expressions.Token> stack = new LinkedList<>();
        while (scanner.hasNext()) {
            String token = scanner.next();
            if (Expressions.RoundBracket.OPENING.equals(token)) {
                stack.push(new Expressions.RoundBracket(token));
            } else if (Expressions.RoundBracket.CLOSING.equals(token)) {
                Expressions.Token infixExpr = stack.pop();
                Expressions.Token t = stack.pop();
                if (t instanceof Expressions.RoundBracket && ((Expressions.RoundBracket) t).isOpening()) {
                    if (stack.isEmpty()) {
                        stack.push(infixExpr);
                    } else {
                        popTokensThenPushNewInfix(stack, infixExpr);
                    }
                } else {
                    stack.push(infixExpr);
                }
            } else if (Expressions.IntNumber.isNumber(token)) {
                Expressions.IntNumber number = new Expressions.IntNumber(token);
                if (stack.isEmpty()) {
                    stack.push(number);
                } else {
                    if (stack.peek() instanceof Expressions.Operation) {
                        popTokensThenPushNewInfix(stack, number);
                    } else {
                        stack.push(number);
                    }
                }
            } else if (Expressions.Operation.isOperation(token)) {
                stack.push(Expressions.Operation.of(token));
            }
        }
        return (Expressions.Infix) stack.pop();
    }

    private static void popTokensThenPushNewInfix(Deque<Expressions.Token> stack, Expressions.Token second) {
        Expressions.Operation operation = (Expressions.Operation) stack.pop();
        Expressions.Expression first = (Expressions.Expression) stack.pop();
        stack.push(new Expressions.Infix(first, operation, (Expressions.Expression) second));
    }
}
