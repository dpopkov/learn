package learn.dsai.ch08trees2;

import java.util.Deque;
import java.util.LinkedList;

import static learn.dsai.tools.Constants.NL;

public class TreeStringBuilder<T> implements BTreeStringBuilder<T> {
    public static final char EMPTY_NODE_DEFAULT_CHAR = '-';

    private StringBuilder builder;
    private final int cellWidth;
    private final String cellFormat;
    private final String emptyCell;
    private final boolean useHorizontals;
    private final char emptyNodeChar;

    public TreeStringBuilder(int cellWidth, boolean useHorizontals) {
        this(cellWidth, useHorizontals, EMPTY_NODE_DEFAULT_CHAR);
    }

    public TreeStringBuilder(int cellWidth, boolean useHorizontals, char emptyNodeChar) {
        this.cellWidth = cellWidth;
        this.useHorizontals = useHorizontals;
        this.emptyNodeChar = emptyNodeChar;
        cellFormat = String.format("%%%ds", cellWidth);
        emptyCell = makeEmpty(cellWidth);
    }

    @Override
    public String build(BNode<T> root) {
        builder = new StringBuilder();
        Deque<BNode<T>> globalStack = new LinkedList<>();
        globalStack.push(root);
        int height = getHeight(root);
        int maxWidth = (int) (Math.pow(2, height) - 1);
        int innerGap = maxWidth;
        int indent = maxWidth / 2;
        boolean lastRow = false;
        if (useHorizontals) {
            addLine(maxWidth * cellWidth);
        }
        while (!lastRow) {
            Deque<BNode<T>> localStack = new LinkedList<>();
            lastRow = true;
            addSpaces(indent * cellWidth);
            while (!globalStack.isEmpty()) {
                BNode<T> temp = globalStack.pop();
                if (temp != null) {
                    builder.append(formatNode(temp));
                    BNode<T> left = temp.getLeft();
                    BNode<T> right = temp.getRight();
                    localStack.push(left);
                    localStack.push(right);
                    if (left != null || right != null) {
                        lastRow = false;
                    }
                } else {
                    builder.append(emptyCell);
                    localStack.push(null);
                    localStack.push(null);
                }
                if (!globalStack.isEmpty()) {
                    addSpaces(innerGap * cellWidth);
                }
            }
            builder.append(NL);
            innerGap /= 2;
            indent /= 2;
            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        if (useHorizontals) {
            addLine(maxWidth * cellWidth);
        }
        return builder.toString();
    }

    private String formatNode(BNode<T> temp) {
        return String.format(cellFormat, temp.getData().toString());
    }

    int getHeight(BNode<T> node) {
        return recursiveTreeHeight(0, node);
    }

    private int recursiveTreeHeight(int starting, BNode<T> node) {
        if (node == null) {
            return starting;
        } else {
            starting++;
            if (node.getLeft() == null && node.getRight() == null) {
                return starting;
            }
            return Math.max(
                    recursiveTreeHeight(starting, node.getLeft()),
                    recursiveTreeHeight(starting, node.getRight())
            );
        }
    }

    private void addSpaces(int numSpaces) {
        for (int j = 0; j < numSpaces; j++) {
            builder.append(' ');
        }
    }

    private void addLine(int length) {
        for (int j = 0; j < length; j++) {
            builder.append('.');
        }
        builder.append(NL);
    }

    private String makeEmpty(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(emptyNodeChar);
        }
        return builder.toString();
    }
}
