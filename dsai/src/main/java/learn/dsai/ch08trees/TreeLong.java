package learn.dsai.ch08trees;

import java.util.StringJoiner;
import java.util.function.LongConsumer;

public class TreeLong {
    private NodeLong root;

    public NodeLong find(long key) {
        NodeLong node = root;
        while (node != null && node.data != key) {
            if (key < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public void insert(long key) {
        NodeLong node = new NodeLong(key);
        if (root == null) {
            root = node;
            return;
        }
        NodeLong parent = root;
        while (true) {
            if (key < parent.data) {
                if (parent.left == null) {
                    parent.left = node;
                    break;
                } else {
                    parent = parent.left;
                }
            } else {
                if (parent.right == null) {
                    parent.right = node;
                    break;
                } else {
                    parent = parent.right;
                }
            }
        }
    }

    public void insert(long[] values) {
        for (long v : values) {
            insert(v);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        traverseInOrder(v -> joiner.add(Long.toString(v)));
        return joiner.toString();
    }

    public void traverseInOrder(LongConsumer out) {
        inOrder(root, out);
    }

    private void inOrder(NodeLong node, LongConsumer out) {
        if (node == null) {
            return;
        }
        inOrder(node.left, out);
        out.accept(node.data);
        inOrder(node.right, out);
    }

    public long minimum() {
        NodeLong last = root;
        NodeLong current = root;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.data;
    }

    public long maximum() {
        NodeLong last = root;
        NodeLong current = root;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last.data;
    }

    public NodeLong delete(long key) {
        NodeLong parent = null;
        NodeLong current = root;
        boolean leftChild = true;
        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left;
                leftChild = true;
            } else {
                current = current.right;
                leftChild = false;
            }
        }
        if (current != null) {
            if (current.left != null && current.right != null) {
                NodeLong successorParent = null;
                NodeLong successor = current.right;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                if (successorParent != null) {
                    successorParent.left = null;
                }
                if (leftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;


                /*NodeLong mostRight = findRight(current.left);
                if (leftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
                mostRight.right = current.right;*/
            } else if (current.left == null && current.right == null) {
                /*if (parent == null) { // current == root
                    root = null;
                    return current;
                }*/
                if (leftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (current.left != null) {
                /*if (parent == null) {
                    root = current.left;
                    return current;
                }*/
                if (leftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else {    // current.right != null
                /*if (parent == null) {
                    root = current.right;
                    return current;
                }*/
                if (leftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        return current;
    }

    NodeLong findLeft(NodeLong parent) {
        if (parent.left == null) {
            return parent;
        }
        return findRight(parent.left);
    }


    NodeLong findRight(NodeLong parent) {
        if (parent.right == null) {
            return parent;
        }
        return findRight(parent.right);
    }
}
