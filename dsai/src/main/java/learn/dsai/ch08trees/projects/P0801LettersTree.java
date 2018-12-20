package learn.dsai.ch08trees.projects;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.IntConsumer;

public class P0801LettersTree {
    private static final String DOTS = "................................................................";

    private final NodeChar root;

    public P0801LettersTree(String s) {
        NodeChar[] forest = makeForest(s);
        makeTree(forest);
        root = forest[0];
    }

    public String buildForDisplay() {
        StringBuilder builder = new StringBuilder();
        Deque<NodeChar> globalStack = new LinkedList<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        appendLine(builder);
        while (!isRowEmpty) {
            Deque<NodeChar> localStack = new LinkedList<>();
            isRowEmpty = true;
            appendIndentation(builder, nBlanks);
            while (!globalStack.isEmpty()) {
                NodeChar temp = globalStack.pop();
                if (temp != null) {
                    builder.append(temp.character);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    builder.append("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                appendIndentation(builder, nBlanks * 2 - 2);
            }
            builder.append(System.lineSeparator());
            nBlanks /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        appendLine(builder);
        return builder.toString();
    }

    private void appendLine(StringBuilder builder) {
        builder.append(DOTS);
        builder.append(System.lineSeparator());
    }

    private void appendIndentation(StringBuilder builder, int nBlanks) {
        for (int j = 0; j < nBlanks; j++) {
            builder.append(' ');
        }
    }

    private void inOrder(NodeChar node, IntConsumer consumer) {
        if (node == null) {
            return;
        }
        inOrder(node.left, consumer);
        consumer.accept(node.character);
        inOrder(node.right, consumer);
    }

    static void makeTree(NodeChar[] forest) {
        for (int i = 1; i < forest.length; i++) {
            NodeChar plus = new NodeChar('+');
            plus.left = forest[0];
            plus.right = forest[i];
            forest[0] = plus;
        }
    }

    static NodeChar[] makeForest(String s) {
        NodeChar[] arr = new NodeChar[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = new NodeChar(s.charAt(i));
        }
        return arr;
    }
}
