package learn.dsajg6e.ch08trees;

import learn.dsajg6e.ch07list.positional.Position;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
            if (left != null) {
                left.setParent(this);
            }
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
            if (right != null) {
                right.setParent(this);
            }
        }

        private void setNullsForGC() {
            element = null;
            left = null;
            right = null;
            parent = null;
        }

        @Override
        public String toString() {
            return "(" + element.toString() + ")";
        }
    }

    /** Root of the tree. */
    protected Node<E> root = null;
    /** Number of nodes in the tree. */
    private int size = 0;

    /** Validates the position and returns it as a node. */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("Position is no longer in the tree");
        }
        return node;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return validate(p).getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return validate(p).getRight();
    }

    /** Returns the root position of the tree (or null if tree is empty). */
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return validate(p).getParent();
    }

    /** Returns the number of nodes in the tree. */
    @Override
    public int size() {
        return size;
    }

    /* Update methods*/

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null);
        size = 1;
        return root;
    }

    /** Creates a new left child of position p storing element e; returns its Position */
    public Position<E> addLeft(Position<E> p, E e) {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("position already has a left child");
        }
        Node<E> child = createNode(e, parent);
        parent.setLeft(child);
        size++;
        return child;
    }

    /** Creates a new right child of position p storing element e; returns its Position */
    public Position<E> addRight(Position<E> p, E e) {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("position already has a right child");
        }
        Node<E> child = createNode(e, parent);
        parent.setRight(child);
        size++;
        return child;
    }

    /** Replaces the element at position p with e and returns the replaced element. */
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E old = node.getElement();
        node.setElement(e);
        return old;
    }

    private Node<E> createNode(E e, Node<E> parent) {
        return new Node<>(e, parent, null, null);
    }

    /** Attaches trees t1 and t2 as left and right subtrees of external p. */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("position must be a leaf");
        }
        if (!t1.isEmpty()) {
            size += t1.size();
            node.setLeft(t1.root);
            t1.clear();
        }
        if (!t2.isEmpty()) {
            size += t2.size();
            node.setRight(t2.root);
            t2.clear();
        }
    }

    /** Makes this tree empty. */
    private void clear() {
        size = 0;
        root = null;
    }

    /** Removes the node at position p and replaces it with its child, if any. */
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("cannot remove position which has 2 children");
        }
        Node<E> child = node.getLeft() != null ? node.getLeft() : node.getRight();
        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setNullsForGC();
        node.setParent(node);
        return temp;
    }

    /**
     * Creates {@code LinkedBinaryTree} instance populated with specified elements
     * in breadth-first order. That is elements 20, 10, 30 make tree where 20 is root,
     * 10 is left, 30 is right.
     * @param elements elements in breadth-first order
     * @param <E> type of elements
     * @return tree populated with elements
     */
    @SafeVarargs
    public static <E> LinkedBinaryTree<E> of(E... elements) {
        LinkedBinaryTree<E> tree = new LinkedBinaryTree<>();
        var r = tree.addRoot(elements[0]);
        Queue<Position<E>> queue = new ArrayDeque<>();
        queue.add(r);
        int i = 1;
        while (!queue.isEmpty() && i < elements.length) {
            r = queue.remove();
            queue.add(tree.addLeft(r, elements[i]));
            queue.add(tree.addRight(r, elements[i + 1]));
            i += 2;
        }
        return tree;
    }
}
