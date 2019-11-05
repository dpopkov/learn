package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.positional.Position;

public abstract class AbstractSkipList<E extends Comparable<E>> implements SkipList<E> {
    protected static class Node<K extends Comparable<K>> implements Position<K> {
        private K key;
        private Node<K> up;
        private Node<K> down;
        private Node<K> left;
        private Node<K> right;

        public Node(K key) {
            this.key = key;
        }

        @Override
        public K getElement() throws IllegalStateException {
            return key;
        }

        public Node<K> getUp() {
            return up;
        }

        public void setUp(Node<K> up) {
            this.up = up;
        }

        public Node<K> getDown() {
            return down;
        }

        public void setDown(Node<K> down) {
            this.down = down;
        }

        public Node<K> getLeft() {
            return left;
        }

        public void setLeft(Node<K> left) {
            this.left = left;
        }

        public Node<K> getRight() {
            return right;
        }

        public void setRight(Node<K> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" + key + '}';
        }
    }

    protected final E minKey;
    protected final E maxKey;
    /** Start position sentinel. */
    protected Node<E> topLeft;
    protected Node<E> topRight;
    protected int size;

    public AbstractSkipList(E minKey, E maxKey) {
        this.minKey = minKey;
        this.maxKey = maxKey;
        topLeft = new Node<>(minKey);
        topRight = new Node<>(maxKey);
        topLeft.setRight(topRight);
        topRight.setLeft(topLeft);
    }

    protected Node<E> toNode(Position<E> position) {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("This position is not a node of a skip list.");
        }
        return (Node<E>) position;
    }

    public int size() {
        return size;
    }
}
