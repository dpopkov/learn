package learn.dsai.ch09rbtrees;

import learn.dsai.ch08trees2.TreeStringBuilder;

/**
 * Red-Black tree.
 *
 * @param <T> type of the element
 */
public class RbTree<T extends Comparable<T>> {
    private RbNode<T> root;
    private TreeStringBuilder<T> builder;

    public RbTree() {
    }

    RbTree(RbNode<T> root) {
        this.root = root;
    }

    RbNode<T> getRoot() {
        return root;
    }

    public void add(T value) {
        RbNode<T> n = new RbNode<>(value);
        if (root == null) {
            root = n;
        } else {
            /*
            On the way down the tree to find the insertion point,
            you perform a color flip
            whenever you find a black node with two red children
             */
            // TODO: implement
        }
    }

    /**
     * Adds new value the the tree without balancing.
     * This method should be used for testing purposes only.
     * @param value new value to insert
     */
    void addNonBalanced(T value) {
        RbNode<T> node = new RbNode<>(value);
        if (root == null) {
            root = node;
        } else {
            RbNode<T> parent = root;
            RbNode<T> current = parent;
            boolean leftChild = false;
            while (current != null) {
                parent = current;
                if (parent.data.compareTo(value) > 0) {
                    leftChild = true;
                    current = parent.left;
                } else {
                    leftChild = false;
                    current = parent.right;
                }
            }
            if (leftChild) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    void addNonBalanced(T... values) {
        for (T value : values) {
            addNonBalanced(value);
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

    void rotateLeft(RbNode<T> parent, RbNode<T> node) {
        if (node.right == null) {
            throw new IllegalStateException("Can not rotate left when has no right sub-node");
        }
        if (node == root || parent == null) {
            root = node.right;
        } else {
            if (node == parent.left) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        }
        RbNode<T> crossNode = node.right.left;
        node.right.left = node;
        node.right = crossNode;
    }

    void rotateRight(RbNode<T> parent, RbNode<T> node) {
        if (node.left == null) {
            throw new IllegalStateException("Can not rotate right when has no left sub-node");
        }
        if (node == root || parent == null) {
            root = node.left;
        } else {
            if (node == parent.left) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        }
        RbNode<T> crossNode = node.left.right;
        node.left.right = node;
        node.left = crossNode;
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
            // TODO: fix the case when left or right red sub-node has black sub-nodes
            return false;
        }
        return isRedBlackCorrect(node.left) && isRedBlackCorrect(node.right);
    }

    boolean blackHeightsEqual(RbNode<T> node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return blackHeightToLeafOrNullChild(node.left) == blackHeightToLeafOrNullChild(node.right);
    }

    private int blackHeightToLeafOrNullChild(RbNode<T> node) {
        /* This node is a null child */
        if (node == null) {
            return 0;
        }
        int blackness = node.isBlack() ? 1 : 0;
        /* This nod is a leaf */
        if (node.left == null && node.right == null) {
            return blackness;
        }
        /* This node is not a leaf */
        int leftPath = blackHeightToLeafOrNullChild(node.left);
        int rightPath = blackHeightToLeafOrNullChild(node.right);
        return blackness + Math.min(leftPath, rightPath);
    }

    @Override
    public String toString() {
        if (builder == null) {
            builder = new TreeStringBuilder<>(4, false, false);
        }
        return builder.build(root);
    }
}
