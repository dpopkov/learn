package learn.dsajg6e.ch08trees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.AbstractTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class NTree<E> extends AbstractTree<E> implements OrderedTree<E> {

    protected static class Node<T> implements Position<T> {
        private T element;
        private Node<T> parent;
        private List<Position<T>> children;
        public Node(T element) {
            this.element = element;
        }

        @Override
        public T getElement() throws IllegalStateException {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> add(T element) {
            Node<T> node = new Node<>(element);
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(node);
            node.setParent(this);
            return node;
        }

        public List<Position<T>> getChildren() {
            return children;
        }

        public int numChildren() {
            return children == null ? 0 : children.size();
        }

        @Override
        public String toString() {
            return "{" + element + '}';
        }
    }

    private Node<E> root;
    private int size;

    public Position<E> addRoot(E element) {
        Node<E> node = new Node<>(element);
        root = node;
        size = 1;
        return node;
    }

    public Position<E> add(Position<E> p, E element) {
        Node<E> parent = validate(p);
        Node<E> node = parent.add(element);
        size++;
        return node;
    }

    public Position<E> set(Position<E> p, E value) {
        Node<E> node = validate(p);
        node.setElement(value);
        return node;
    }

    protected Node<E> validate(Position<E> p) {
        Objects.requireNonNull(p);
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("This position is not from the tree");
        }
        return (Node<E>) p;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return validate(p).getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        return validate(p).getChildren();
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return validate(p).numChildren();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Position<E>> inOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        inOrderSubTree(root(), snapshot);
        return snapshot;
    }

    private void inOrderSubTree(Position<E> p, List<Position<E>> snapshot) {
        Iterable<Position<E>> children = children(p);
        Iterator<Position<E>> it = null;
        int num = -1;
        if (children != null) {
            num = numChildren(p);
            it = children.iterator();
            int n = num / 2;
            for (int i = 0; i < n; i++) {
                inOrderSubTree(it.next(), snapshot);
            }
        }
        snapshot.add(p);
        if (it != null && num > 0) {
            int n  = num - num / 2;
            for (int i = 0; i < n; i++) {
                inOrderSubTree(it.next(), snapshot);
            }
        }
    }
}
