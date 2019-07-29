package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
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
}
