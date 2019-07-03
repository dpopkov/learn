package learn.dsajg6e.ch06stacks;

/**
 * CF 6.7
 * Matching delimiters in arithmetic expressions.
 */
public class MatchingParentheses {
    private static final String OPENING = "([{";
    private static final String CLOSING = ")]}";

    static boolean isMatched(String expression) {
        Stack<Character> stack = new ArrayStack<>(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (openingIndex(c) != -1) {
                stack.push(c);
            } else {
                int closing = closingIndex(c);
                if (closing != -1) {
                    if (stack.isEmpty() || openingIndex(stack.pop()) != closing) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static int closingIndex(char c) {
        return CLOSING.indexOf(c);
    }

    private static int openingIndex(char c) {
        return OPENING.indexOf(c);
    }
}
