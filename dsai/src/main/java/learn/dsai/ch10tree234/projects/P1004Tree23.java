package learn.dsai.ch10tree234.projects;

import java.util.StringJoiner;
import java.util.function.Consumer;

/**
 * 2-3 tree
 */
public class P1004Tree23<E extends Comparable<? super E>> {
    private Node23<E> root;

    public P1004Tree23() {
        root = new Node23<>();
    }

    Node23<E> getRoot() {
        return root;
    }

    public void insert(E value) {
        /* All insertions are made into leaf nodes. */
        Node23<E> current = root;
        while (!current.isLeaf()) {
            current = current.findNext(value);
        }
        if (current.isFull()) {
            split(current, value);
        } else {
            current.insert(value);
        }
    }

    @SafeVarargs
    public final void insert(E... values) {
        for (E value : values) {
            insert(value);
        }
    }

    private Node23<E> split(Node23<E> node, E value) {
        E middleValue = node.squeezeMiddleValue(value);
        E rightValue = node.removeItem(1);
        Node23<E> rightNode = new Node23<>(rightValue);
        rightNode.connect(node.removeLastNode());   // TODO: not sure - check/fix
        Node23<E> parent = node.getParent();
        if (parent == null) {
            Node23<E> newRoot = new Node23<>(middleValue);
            newRoot.connect(node);
            newRoot.connect(rightNode);
            root = newRoot;
        } else {
            if (parent.isFull()) {
                Node23<E> parentRight = split(parent, middleValue);
                parentRight.connect(rightNode);
            } else {
                parent.insert(middleValue);
                parent.connect(rightNode);
            }
        }
        return rightNode;
    }

    public String toStringInOrder() {
        StringJoiner joiner = new StringJoiner("/", "", "");
        traverseInOrder(v -> joiner.add(v.toString()));
        return joiner.toString();
    }

    public void traverseInOrder(Consumer<E> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node23<E> node, Consumer<E> consumer) {
        int i;
        for (i = 0; i < node.getNumItems(); i++) {
            inOrder(node.getNode(i), consumer);
            consumer.accept(node.getItem(i));
        }
        inOrder(node.getNode(i), consumer);
    }

    public void traverseByLevels(Consumer<E> consumer) {
        // TODO: implement
    }

    // TODO: make P1004Tree23App with print in order and by levels
}
