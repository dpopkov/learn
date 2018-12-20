package learn.dsai.ch08trees;

import java.util.Deque;
import java.util.LinkedList;

public class BTreeDisplayBuilder {
    private static final String DOTS = "................................................................";

    /**
     * Builds string representation of the tree as pseudo graphic.
     * Allows up to 5 levels of tree. If there are more levels, then
     * the values at level greater than 5 will not be separated.
     * @return pseudo graphic representation of the tree
     */
    public String buildForDisplay(BTreeNode root) {
        StringBuilder builder = new StringBuilder();
        Deque<BTreeNode> globalStack = new LinkedList<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        appendLine(builder);
        while (!isRowEmpty) {
            Deque<BTreeNode> localStack = new LinkedList<>();
            isRowEmpty = true;
            appendIndentation(builder, nBlanks);
            while (!globalStack.isEmpty()) {
                BTreeNode temp = globalStack.pop();
                if (temp != null) {
                    builder.append(temp.toString());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null) {
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
}
