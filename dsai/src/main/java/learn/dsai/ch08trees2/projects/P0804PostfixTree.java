package learn.dsai.ch08trees2.projects;

import learn.dsai.ch08trees2.TreeStringBuilder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Transforms a postfix expression into a tree.
 */
public class P0804PostfixTree {
    private static final String LOW_PRECEDENCE_OPERATORS = "+-";
    private static final String OPERATORS = LOW_PRECEDENCE_OPERATORS + "*/";

    private final CharNode root;
    private TreeStringBuilder<Character> builder;

    public P0804PostfixTree(String postfix) {
        root = buildTree(postfix);
    }

    private CharNode buildTree(String postfix) {
        Deque<CharNode> stack = new LinkedList<>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            CharNode node = new CharNode(ch);
            if (isOperator(ch)) {
                CharNode rightOperand = stack.pop();
                node.left = stack.pop();
                node.right = rightOperand;
            }
            stack.push(node);
        }
        return stack.pop();
    }

    public String getInfix() {
        StringBuilder buffer = new StringBuilder();
        traverseInfix(root, buffer::append);
        return buffer.toString();
    }

    private void traverseInfix(CharNode node, Consumer<Character> consumer) {
        if (node == null) {
            return;
        }
        boolean parenthesised = isLowPrecedenceOperator(node.character) && node != root;
        if (parenthesised) {
            consumer.accept('(');
        }
        traverseInfix(node.left, consumer);
        consumer.accept(node.character);
        traverseInfix(node.right, consumer);
        if (parenthesised) {
            consumer.accept(')');
        }
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(1, false, ' ');
        }
        return builder.build(root);
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) > -1;
    }

    private static boolean isLowPrecedenceOperator(char ch) {
        return LOW_PRECEDENCE_OPERATORS.indexOf(ch) > -1;
    }
}
