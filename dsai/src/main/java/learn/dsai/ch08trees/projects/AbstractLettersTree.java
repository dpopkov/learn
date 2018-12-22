package learn.dsai.ch08trees.projects;

import learn.dsai.ch08trees.BTreeDisplayBuilder;

import java.util.StringJoiner;
import java.util.function.IntConsumer;

public abstract class AbstractLettersTree {
    protected final NodeChar root;

    public AbstractLettersTree(String s) {
        NodeChar[] forest = makeForest(s);
        makeTree(forest);
        root = forest[0];
    }

    public abstract void makeTree(NodeChar[] forest);

    NodeChar[] makeForest(String s) {
        NodeChar[] arr = new NodeChar[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = new NodeChar(s.charAt(i));
        }
        return arr;
    }

    public String buildForDisplay() {
        return new BTreeDisplayBuilder().buildForDisplay(root);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        inOrder(root, v -> joiner.add(Character.toString((char)v)));
        return joiner.toString();
    }

    protected void inOrder(NodeChar node, IntConsumer consumer) {
        if (node == null) {
            return;
        }
        inOrder(node.left, consumer);
        consumer.accept(node.character);
        inOrder(node.right, consumer);
    }

    protected void preOrder(NodeChar node, IntConsumer consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.character);
        preOrder(node.left, consumer);
        preOrder(node.right, consumer);
    }

    protected void postOrder(NodeChar node, IntConsumer consumer) {
        if (node == null) {
            return;
        }
        postOrder(node.left, consumer);
        postOrder(node.right, consumer);
        consumer.accept(node.character);
    }
}
