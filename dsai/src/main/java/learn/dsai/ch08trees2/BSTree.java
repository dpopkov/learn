package learn.dsai.ch08trees2;

import java.util.StringJoiner;
import java.util.function.Consumer;

/**
 * Binary Search Tree.
 */
public class BSTree<T extends Comparable<T>> {
    private Node<T> root;

    /** This constructor has package level access for unit-testing purposes. */
    BSTree(Node<T> root) {
        this.root = root;
    }

    public BSTree() {
    }

    public T find(T value) {
        Node<T> node = root;
        while (node != null) {
            int c = node.data.compareTo(value);
            if (c == 0) {
                return node.data;
            } else if (c > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void insert(T value) {
        Node<T> node = new Node<>(value);
        if (root == null) {
            root = node;
        } else {
            Node<T> parent = root;
            boolean searching = true;
            while (searching) {
                int cmp = parent.data.compareTo(value);
                if (cmp > 0) {
                    if (parent.left == null) {
                        parent.left = node;
                        searching = false;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = node;
                        searching = false;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
    }

    @SafeVarargs
    public final void insert(T... values) {
        for (T value : values) {
            insert(value);
        }
    }

    public void inOrder(Consumer<T> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            inOrder(node.left, consumer);
            consumer.accept(node.data);
            inOrder(node.right, consumer);
        }
    }

    public T minimum() {
        Node<T> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public T maximum() {
        Node<T> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public boolean delete(T value) {
        Node<T> parent = root;
        Node<T> node = root;
        boolean leftChild = false;
        while (node != null && !node.data.equals(value)) {
            parent = node;
            if (value.compareTo(parent.data) < 0) {
                node = parent.left;
                leftChild = true;
            } else {
                node = parent.right;
                leftChild = false;
            }
        }
        if (node == null) {
            return false;
        }
        Node<T> delNode = node;
        if (delNode.left == null && delNode.right == null) {
            updateLinks(parent, leftChild, delNode, null);
        } else if (delNode.left == null) {
            updateLinks(parent, leftChild, delNode, delNode.right);
        } else if (delNode.right == null) {
            updateLinks(parent, leftChild, delNode, delNode.left);
        } else {
            Node<T> successor = getSuccessor(delNode);
            successor.left = delNode.left;
            updateLinks(parent, leftChild, delNode, successor);
        }
        return true;
    }

    private void updateLinks(Node<T> parent, boolean leftChild, Node<T> toDelete, Node<T> substitute) {
        if (toDelete == root) {
            root = substitute;
        } else if (leftChild) {
            parent.left = substitute;
        } else {
            parent.right = substitute;
        }
    }

    private Node<T> getSuccessor(Node<T> node) {
        Node<T> parent = node;
        Node<T> current = node.right;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        if (parent != node) {
            parent.left = current.right;
            current.right = node.right;
        }
        return current;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        inOrder(e -> joiner.add(e.toString()));
        return joiner.toString();
    }

    BNode<T> getRoot() {
        return root;
    }

    static class Node<T extends Comparable<T>> implements BNode<T> {
        final T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
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
    }
}
