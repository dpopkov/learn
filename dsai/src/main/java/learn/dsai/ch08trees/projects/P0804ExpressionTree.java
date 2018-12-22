package learn.dsai.ch08trees.projects;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

public class P0804ExpressionTree extends AbstractLettersTree {

    public P0804ExpressionTree(String s) {
        super(s);
    }

    /** Used for unit-testing purposes. */
    NodeChar getRoot() {
        return root;
    }

    @Override
    public void makeTree(NodeChar[] forest) {
        Deque<NodeChar> stack = new LinkedList<>();
        for (NodeChar node : forest) {
            if ('0' <= node.character && node.character <= '9') {
                stack.push(node);
            } else {
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
        }
        forest[0] = stack.pop();
    }



    @Override
    public String buildForDisplay() {
        String tree = super.buildForDisplay();
        StringJoiner infix = new StringJoiner("", "Infix: ", System.lineSeparator());
        inOrder(root, ch -> infix.add(intToString(ch)));
        StringJoiner postfix = new StringJoiner("", "Postfix: ", System.lineSeparator());
        postOrder(root, ch -> postfix.add(intToString(ch)));
        StringJoiner prefix = new StringJoiner("", "Prefix: ", System.lineSeparator());
        preOrder(root, ch -> prefix.add(intToString(ch)));
        return prefix.toString() + infix.toString() + postfix.toString() + tree;
    }

    private String intToString(int ch) {
        return Character.toString((char) ch);
    }
}
