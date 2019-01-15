package learn.dsai.ch09rbtrees;

import learn.dsai.ch08trees2.TreeStringBuilder;

/**
 * Red-Black tree.
 *
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

    private void changeNodeColor(RbNode<T> node) {
        node.black = !node.black;
    }

    void rotateLeft(RbNode<T> node) {

    }

    void rotateRight(RbNode<T> node) {

    }

    boolean isRedBlackCorrect() {
        if (root.isRed()) {
            return false;
        }
        return isRedBlackCorrect(root.left) && isRedBlackCorrect(root.right);
    }

    /**
     * Checks whether the sub-tree is red-black correct.
     *
     * @param node root node of the sub-tree
     * @return true if correct
     */
    boolean isRedBlackCorrect(RbNode<T> node) {
        if (node == null) {
            return true;
        }
        if (node.isRed()
                && ((node.left != null && node.left.isRed())
                || (node.right != null && node.right.isRed()))) {
            return false;
        }
        if (node.isBlack()
                && ((node.left != null && node.left.isBlack() && (node.right == null || node.right.isRed()))
                || ((node.right != null && node.right.isBlack() && (node.left == null || node.left.isRed()))))) {
            return false;
        }
        return isRedBlackCorrect(node.left) && isRedBlackCorrect(node.right);
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(4, false, false);
        }
        return builder.build(root);
    }
}
