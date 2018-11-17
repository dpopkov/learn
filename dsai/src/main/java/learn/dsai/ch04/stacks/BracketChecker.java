/* 4.3 */
package learn.dsai.ch04.stacks;

public class BracketChecker {
    private static final String OPENING = "([{";
    private static final String CLOSING = ")]}";

    private final String input;
    private String error;

    public BracketChecker(String input) {
        this.input = input;
    }

    public String getError() {
        return error;
    }

    public boolean check() {
        int stackSize = input.length();
        StackChar stack = new StackChar(stackSize);
        for (int j = 0; j < stackSize; j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if (ch == '}' && chx != '{'
                                || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '(')
                        ) {
                            error = "Error: " + ch + " at " + j;
                            System.out.println(error);
                            return false;
                        }
                    } else {
                        error = "Error: " + ch + " at " + j;
                        System.out.println(error);
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            error = "Error: missing right delimiter";
            System.out.println(error);
            return false;
        }
        return true;
    }

    /**
     * My implementation of method {@code check}.
     * @return true if balanced, false otherwise
     */
    public boolean isBalanced() {
        StackChar stack = new StackChar(input.length());
        for (char ch : input.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(ch);
            } else if (isClosing(ch)) {
                if (stack.isEmpty()) {
                    error = "no opening for " + ch;
                    return false;
                }
                char opening = stack.peek();
                if (match(opening, ch)) {
                    stack.pop();
                } else {
                    error = "no match for " + ch;
                    return false;
                }
            }
        }
        boolean empty = stack.isEmpty();
        if (!empty) {
            error = "no closing for " + stack.pop();
        }
        return empty;
    }

    private static boolean isOpening(char ch) {
        return OPENING.indexOf(ch) >= 0;
    }

    private static boolean isClosing(char ch) {
        return CLOSING.indexOf(ch) >= 0;
    }

    private static boolean match(char opening, char closing) {
        int p1 = OPENING.indexOf(opening);
        int p2 = CLOSING.indexOf(closing);
        return p1 == p2;
    }
}
