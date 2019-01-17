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
            RbNode<T> parent = root;
            RbNode<T> childLink = root;
            boolean leftChild = false;
            while (childLink != null) {
                parent = childLink;
                /* 1. Color flips on the way down whenever you find
                a black node with two red children */
                if (parent.isBlack()
                        && parent.left != null && parent.left.isRed()
                        && parent.right != null && parent.right.isRed()) {
                    flipColor(parent);
                }
                /* 2. Rotations on the way down */
                // TODO: implement rotations

                if (parent.data.compareTo(value) > 0) {
                    childLink = parent.left;
                    leftChild = true;
                } else {
                    childLink = parent.right;
                    leftChild = false;
                }
            }
            /* Now insert the node */
            if (leftChild) {
                parent.left = n;
            } else {
                parent.right = n;
            }
            /* 3. Rotations after the node is inserted */
            // TODO: implement rotation after insert
        }
    }

    @SafeVarargs
    public final void add(T... values) {
        for (T value : values) {
            add(value);
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

    @SafeVarargs
    final void addNonBalanced(T... values) {
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
        /* Red-Black Rule 1: The root is always black */
        if (root.isRed()) {
            return false;
        }
        return isRedBlackCorrectByColor(root) && blackHeightsEqual(root);
    }

    /**
     * Checks whether the sub-tree is red-black correct.
     *
     * @param node root node of the sub-tree
     * @return true if correct
     */
    boolean isRedBlackCorrectByColor(RbNode<T> node) {
        if (node == null) {
            return true;
        }
        /* Red-Black Rule 3: if the node is red its children must be black. */
        if (node.isRed()
                && ((node.left != null && node.left.isRed())
                || (node.right != null && node.right.isRed()))) {
            return false;
        }
        /* Red-Black Rule 4: (part of it - when color is enough for detecting)*/
        if (node.isBlack()
                && ((node.left != null && node.left.isBlack() && (node.right == null/* || node.right.isRed()*/))
                || ((node.right != null && node.right.isBlack() && (node.left == null/* || node.left.isRed()*/))))) {
            return false;
        }
        return isRedBlackCorrectByColor(node.left) && isRedBlackCorrectByColor(node.right);
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
