package learn.dsai.ch09rbtrees;

import learn.dsai.ch08trees2.BNode;

public class RbNode<T> implements BNode<T> {
    static final boolean RED = false;
    static final boolean BLACK = true;

    final T data;
    boolean black;
    RbNode<T> left;
    RbNode<T> right;

    public RbNode(T data) {
        this.data = data;
        this.black = RED;
    }

    RbNode(T data, boolean black) {
        this.data = data;
        this.black = black;
    }

    public boolean isBlack() {
        return black;
    }

    public boolean isRed() {
        return !black;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public BNode<T> getLeft() {
        return left;
    }

    @Override
    public BNode<T> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return (black ? "B" : "R") + ":" + data;
    }
}
