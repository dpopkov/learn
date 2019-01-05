package learn.dsai.ch08trees2;

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

    public void insert(T... values) {
        for (T value : values) {
            insert(value);
        }
    }

    public boolean delete(T value) {
        return false;
    }

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
