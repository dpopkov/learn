package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    protected interface BinaryNode<T> extends Position<T> {
        BinaryNode<T> getParent();
        BinaryNode<T> getLeft();
        BinaryNode<T> getRight();
    }

    /** Returns the Position of p's sibling (or null if no sibling exists). */
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null;
        }
        if (p == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    /** Returns the number of children of position p. */
    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    /** Returns an iterable collection containing the children of position p (if any). */
    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return inOrder();
    }

    /** Returns an iterable collection of positions of the tree, reported in in-order. */
    public Iterable<Position<E>> inOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inOrderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void inOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inOrderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inOrderSubtree(right(p), snapshot);
        }
    }

    /* C-8.45 */
    /** Return the position visited after p in a pre-order traversal or null if p is the last node. */
    public Position<E> preOrderNext(Position<E> p) {
        if (left(p) != null) {
            return left(p);
        }
        BinaryNode<E> binary = validateBinary(p);
        BinaryNode<E> parent = binary.getParent();
        if (parent.getLeft() == p) {
            return this.right(parent);
        } else if (parent.getRight() == p) {
            parent = findParentOfRightSubTree(p);
            if (parent != null) {
                return parent.getRight();
            }
        }
        return null;
    }

    private BinaryNode<E> findParentOfRightSubTree(Position<E> p) {
        BinaryNode<E> node = validateBinary(p);
        BinaryNode<E> parent = node.getParent();
        while (parent != null && right(parent) == node) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public Position<E> inOrderNext(Position<E> p) {
        BinaryNode<E> node = validateBinary(p);
        if (right(node) != null) {
            return findMostLeftInRightSubTree(node);
        } else if (isRightSubTree(node)) {
            return findParentOfLeftSubTree(node.getParent());
        }
        BinaryNode<E> parent = node.getParent();
        if (parent != null && node == left(parent)) {
            return parent;
        }
        return null;
    }

    public Position<E> postOrderNext(Position<E> p) {
        BinaryNode<E> node = validateBinary(p);
        if (isLeftSubTree(node)) {
            Position<E> sibling = sibling(node);
            if (left(sibling) == null) {
                return sibling;
            } else {
                return findMostLeft((BinaryNode<E>) sibling);
            }
        } else if (isRightSubTree(node)) {
            return node.getParent();
        }
        return null;
    }

    private BinaryNode<E> findMostLeft(BinaryNode<E> p) {
        Position<E> left = left(p);
        while (left(left) != null) {
            left = left(left);
        }
        return (BinaryNode<E>) left;
    }

    private BinaryNode<E> findMostLeftInRightSubTree(BinaryNode<E> p) {
        BinaryNode<E> right = (BinaryNode<E>) right(p);
        Position<E> left = left(right);
        if (left == null) {
            return right;
        }
        while (left(left) != null) {
            left = left(left);
        }
        return (BinaryNode<E>) left;
    }

    private Position<E> findParentOfLeftSubTree(BinaryNode<E> p) {
        BinaryNode<E> up = p.getParent();
        while (up != null && left(up) != p) {
            p = up;
            up = up.getParent();
        }
        return up;
    }

    private boolean isRightSubTree(BinaryNode<E> p) {
        BinaryNode<E> parent = p.getParent();
        return parent != null && right(parent) == p;
    }

    private boolean isLeftSubTree(BinaryNode<E> p) {
        BinaryNode<E> parent = p.getParent();
        return parent != null && left(parent) == p;
    }


    private BinaryNode<E> validateBinary(Position<E> p) {
        if (!(p instanceof BinaryNode)) {
            throw new IllegalArgumentException("Not a binary node");
        }
        return (BinaryNode<E>) p;
    }
}
