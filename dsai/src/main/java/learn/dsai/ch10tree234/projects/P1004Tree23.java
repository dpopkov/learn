package learn.dsai.ch10tree234.projects;

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

    private void split(Node23<E> node, E value) {
        E middleValue = node.squeezeMiddleValue(value);
        E rightValue = node.removeItem(1);
        Node23<E> rightNode = new Node23<>(rightValue);
        Node23<E> parent = node.getParent();
        if (parent == null) {
            Node23<E> newRoot = new Node23<>(middleValue);
            newRoot.connect(node);
            newRoot.connect(rightNode);
            root = newRoot;
        } else {
            parent.insert(middleValue);
            parent.connect(rightNode);
        }
    }
}
