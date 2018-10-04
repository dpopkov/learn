package learn.ijpds.ch20collections.exercises;

import learn.csia.utils.CliAppArgs;
import learn.ijpds.tools.SentenceBuilder;

import java.util.ArrayDeque;
import java.util.Deque;

public class E2014Infix {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter infix expression");
        String infix = cli.nextLine();
        String postfix = new E2014Infix().toPostfix(infix);
        int result = new E2013Postfix().evaluate(postfix);
        System.out.println("result = " + result);
    }

    /**
     * Converts expression in infix notation to postfix notation.
     * @param infix expression in infix notation containing allowed operators +, -, *, /
     * @return expression in postfix notation
     */
    public String toPostfix(String infix) {
        if (infix.isEmpty()) {
            throw new IllegalArgumentException("Can not convert empty infix string");
        }
        Deque<String> operators = new ArrayDeque<>();
        SentenceBuilder builder = new SentenceBuilder();
        String[] tokens = infix.split(" ");
        builder.append(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                builder.append(token);
                String op = operators.peek();
                if ("*".equals(op) || "/".equals(op) || i == tokens.length - 1) {
                    builder.append(operators.pop());
                }
            } else {
                if ("+".equals(token) || "-".equals(token)) {
                    while (!operators.isEmpty()) {
                        builder.append(operators.pop());
                    }
                }
                operators.push(token);
            }
        }
        while (!operators.isEmpty()) {
            builder.append(operators.pop());
        }
        return builder.toString();
    }

    private boolean isNumber(String s) {
        return s.matches("\\d+");
    }
}
