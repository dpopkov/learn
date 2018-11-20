/* 4.7 */
package learn.dsai.ch04.parsing;

import learn.dsai.ch04.stacks.StackChar;

/**
 * Converts expression in infix notation to postfix notation.
 */
public class InToPost {
    private final boolean log;
    private final StackChar stack;
    private final String input;
    private final StringBuilder output = new StringBuilder();

    public InToPost(String input) {
        this(input, false);
    }

    public InToPost(String input, boolean log) {
        this.input = input;
        this.log = log;
        stack = new StackChar(input.length());
    }

    public String translate() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            displayStackFor(ch);
            switch(ch) {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    output.append(ch);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            displayStack("While ");
            output.append(stack.pop());
        }
        displayStack("End   ");
        return output.toString();
    }

    private void gotParen() {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output.append(chx);
            }
        }
    }

    private void gotOperator(char opThis, int precedence1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int precedence2;
                if (opTop == '+' || opTop == '-') {
                    precedence2 = 1;
                } else {
                    precedence2 = 2;
                }
                if (precedence2 < precedence1) {
                    stack.push(opTop);
                    break;
                } else {
                    output.append(opTop);
                }
            }
        }
        stack.push(opThis);
    }

    private void displayStackFor(char ch) {
        displayStack("For " + ch + " ");
    }

    private void displayStack(String s) {
        if (log) {
            System.out.print(s);
            System.out.print("Stack (bottom-->top): ");
            System.out.println(stack);
        }
    }
}
