package learn.dsai.ch10tree234;

public class Tree234 {
    private Node root;

    /** Constructor for testing purposes only. */
    Tree234(Node root) {
        this.root = root;
    }

    public Tree234() {
        root = new Node();
    }

    /**
     * Gets the root for unit-testing.
     * @return root node
     */
    Node getRoot() {
        return root;
    }

    /** Finds index of node or -1. */
    public int find(long key) {
        Node current = root;
        int idx;
        while (true) {
            if ((idx = current.findItem(key)) != -1) {
                return idx;
            } else if (current.isLeaf()) {
                return -1;
            } else {
                current = getNext(current, key);
            }
        }
    }

    // pre: node is not leaf
    private Node getNext(Node node, long key) {
        int numItems = node.getNumItems();
        for (int i = 0; i < numItems; i++) {
            if (key < node.getItem(i).getData()) {
                return node.getNode(i);
            }
        }
        return node.getNode(numItems);
    }

    public void insert(long value) {
        Node current = root;
        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();
                current = getNext(current, value);
            } else if (current.isLeaf()) {
                break;
            } else {
                current = getNext(current, value);
            }
        }
        DataItem item = new DataItem(value);
        current.insertItem(item);
    }

    /**
     * Splits the full node.
     * Package level access is assigned for unit-testing purposes.
     * @param node node to split
     */
    void split(Node node) {
        Node right = new Node();
        right.insertItem(node.removeItem());
        right.connect(0, node.disconnect(2));
        right.connect(1, node.disconnect(3));
        Node parent = node.getParent();
        if (parent == null) {   // new root
            parent = new Node();
            root = parent;
        }
        parent.insertItem(node.removeItem());
        parent.insert(node);
        parent.insert(right);
    }
}
