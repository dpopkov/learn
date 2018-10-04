package learn.ijpds.ch20collections.exercises;

/**
 * Evaluates expression in infix notation containing only +, -, *, / operators
 * and integer operands.
 */
public class Evaluator {
    private E2014Infix infix = new E2014Infix();
    private E2013Postfix postfix = new E2013Postfix();

    public int evaluate(String infixNotation) {
        return postfix.evaluate(infix.toPostfix(infixNotation));
    }
}
