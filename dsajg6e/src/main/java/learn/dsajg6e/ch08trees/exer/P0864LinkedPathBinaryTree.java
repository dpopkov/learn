package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.AbstractBinaryTree;
import learn.dsajg6e.ch08trees.AppendableBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Linked binary tree that implements a Position as an object that keeps a list of nodes
 * representing the entire path from the root to that position.
 */
public class P0864LinkedPathBinaryTree<E> extends AbstractBinaryTree<E> implements AppendableBinaryTree<E> {

    private static class Node<E> {
        private E element;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> left, Node<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public E getElement() throws IllegalStateException {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + element.toString() + ")";
        }
    }

    private static class Path<T> implements Position<T> {
        private final List<Node<T>> pathNodes;

        private Path(Node<T> node) {
            pathNodes = new ArrayList<>(1);
            pathNodes.add(node);
        }

        private Path(Path<T> path) {
            pathNodes = new ArrayList<>(path.pathNodes);
        }

        private Path(List<Node<T>> nodes) {
            pathNodes = new ArrayList<>(nodes);
        }

        @Override
        public T getElement() throws IllegalStateException {
            return getLast().getElement();
        }

        public Node<T> getLast() {
            return pathNodes.get(pathNodes.size() - 1);
        }

        private void add(Node<T> node) {
            pathNodes.add(node);
        }

        static <T> Path<T> toChild(Path<T> parent, Node<T> child) {
            Path<T> p = new Path<>(parent);
            p.add(child);
            return p;
        }

        static <T> Path<T> toParent(Path<T> toChild) {
            return new Path<>(toChild.pathNodes.subList(0, toChild.pathNodes.size() - 1));
        }
    }

    private Node<E> root;
    private int size;

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Path<E> toParent = validate(p);
        return Path.toChild(toParent, toParent.getLast().getLeft());
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Path<E> toParent = validate(p);
        return Path.toChild(toParent, toParent.getLast().getRight());
    }

    @Override
    public Position<E> root() {
        return new Path<>(root);
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Path<E> toChild = validate(p);
        return Path.toParent(toChild);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        Node<E> node = new Node<>(e, null, null);
        root = node;
        size = 1;
        return new Path<>(node);
    }

    @Override
    public Position<E> addLeft(Position<E> p, E e) {
        Path<E> toParent = validate(p);
        Node<E> node = new Node<>(e, null, null);
        Node<E> parent = toParent.getLast();
        parent.setLeft(node);
        size++;
        return Path.toChild(toParent, node);
    }

    @Override
    public Position<E> addRight(Position<E> p, E e) {
        Path<E> toParent = validate(p);
        Node<E> node = new Node<>(e, null, null);
        Node<E> parent = toParent.getLast();
        parent.setRight(node);
        size++;
        return Path.toChild(toParent, node);
    }

    @Override
    public E set(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private Path<E> validate(Position<E> p) {
        if (!(p instanceof Path)) {
            throw new IllegalArgumentException("This position does not have valid type.");
        }
        return (Path<E>) p;
    }
}
