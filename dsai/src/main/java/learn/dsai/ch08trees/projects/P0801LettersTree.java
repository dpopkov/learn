package learn.dsai.ch08trees.projects;

import learn.dsai.ch08trees.BTreeDisplayBuilder;

import java.util.StringJoiner;
import java.util.function.IntConsumer;

public class P0801LettersTree {
    private final NodeChar root;

    public P0801LettersTree(String s) {
        NodeChar[] forest = makeForest(s);
        makeTree(forest);
        root = forest[0];
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
