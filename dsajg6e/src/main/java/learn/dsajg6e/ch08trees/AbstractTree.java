package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

import java.util.*;

/**
 * An abstract base class providing some functionality of the {@link Tree} interface.
 * @param <E> type of elements in the tree
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /** Returns the number of levels separating Position p from the root. */
    @SuppressWarnings("unused")
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /** Returns the height of the subtree rooted at Position p. */
    @SuppressWarnings("unused")
    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /** Iterates all elements of {@code AbstractTree} instance, based upon
     * an iteration of the positions of the tree. */
    private class ElementIterator implements Iterator<E> {
        private final Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

    @Override
    public Iterable<Position<E>> positions() {
        return preOrder();
    }

    @Override
    public E firstChild(Position<E> p) {
        return children(p).iterator().next().getElement();
    }

    /** Returns iterable container of the positions of the tree in pre-order. */
    public Iterable<Position<E>> preOrder() {
        List<Position<E>> snapshot = new ArrayList<>(size());
        preOrderSubtree(root(), snapshot);
        return snapshot;
    }

    /** Performs a pre-order traversal of the sub-tree rooted at position p of a tree. */
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p)) {
            preOrderSubtree(c, snapshot);
        }
    }

    /** Returns an iterable collection of positions of the tree, reported in post-order. */
    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapshot = new ArrayList<>(size());
        postOrderSubtree(root(), snapshot);
        return snapshot;
    }

    /** Adds positions of the sub-tree rooted at position p to the given snapshot in post-order. */
    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postOrderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }

    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapshot = new ArrayList<>(size());
        if (!isEmpty()) {
            Queue<Position<E>> queue = new ArrayDeque<>();
            queue.add(root());
            while (!queue.isEmpty()) {
                Position<E> p = queue.remove();
                snapshot.add(p);
                for (Position<E> child : children(p)) {
                    queue.add(child);
                }
            }
        }
        return snapshot;
    }

    @SuppressWarnings("unused")
    public void printPreOrderIndent() {
        printPreOrderIndent(this, root(), 0);
    }

    static <E> void printPreOrderIndent(AbstractTree<E> tree, Position<E> p, int depth) {
        System.out.println(spaces(depth * 2) + p.getElement());
        for (Position<E> c : tree.children(p)) {
            printPreOrderIndent(tree, c, depth + 1);
        }
    }

    public void printPreOrderLabeled() {
        printPreOrderLabeled(this, root(), new ArrayList<>());
    }

    static <E> void printPreOrderLabeled(Tree<E> tree, Position<E> p, ArrayList<Integer> path) {
        int depth = path.size();
        System.out.print(spaces((depth * 2)));
        for (int j = 0; j < depth; j++) {
            System.out.print(path.get(j) + (j == depth - 1 ? " " : "."));
        }
        System.out.println(p.getElement());
        path.add(1);
        for (Position<E> c : tree.children(p)) {
            printPreOrderLabeled(tree, c, path);
            path.set(depth, 1 + path.get(depth));
        }
        path.remove(depth);
    }

    private static String spaces(int num) {
        return " ".repeat(num);
    }
}
