package learn.dsai.ch09rbtrees;

import learn.dsai.ch08trees2.TreeStringBuilder;

/**
 * Red-Black tree.
 * @param <T> type of the element
 */
public class RbTree<T> {
    private RbNode<T> root;
    private TreeStringBuilder<T> builder;

    public RbTree() {
    }

    RbTree(RbNode<T> root) {
        this.root = root;
    }

    public void add(T value) {
        RbNode<T> n = new RbNode<>(value);
        if (root == null) {
            root = n;
        }
    }

    void flipColor(RbNode<T> node) {
        if (node.left == null || node.right == null) {
            throw new IllegalStateException("Node has no children");
        }
        if (node.left.black != node.right.black) {
            throw new IllegalStateException("Children have different colors");
        }
        boolean colorForChildren = (node != root) ? node.black : !node.left.black;
        node.black = (node == root) || node.left.black;
        node.left.black = colorForChildren;
        node.right.black = colorForChildren;
    }

    private void chaingeNodeColor(RbNode<T> node) {
        node.black = !node.black;
    }

    void rotateLeft(RbNode<T> node) {

    }

    void rotateRight(RbNode<T> node) {

    }

    /**
     * Checks whether the sub-tree is red-black correct.
     * @param node root node of the sub-tree
     * @return true if correct
     */
    boolean isRedBlackCorrect(RbNode<T> node) {
        // TODO: implement
        return false;
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(4, false, false);
        }
        return builder.build(root);
    }
}
