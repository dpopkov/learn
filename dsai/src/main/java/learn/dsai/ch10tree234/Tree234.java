package learn.dsai.ch10tree234;

public class Tree234 {
    protected Node root;

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

    public void insert(Long... values) {
        for (Long v : values) {
            insert(v);
        }
    }

    /**
     * Splits the full node.
     * Package level access is assigned for unit-testing purposes.
     * This implementation is not tested properly!!!.
     * @param node node to split
     */
    void split(Node node) {
        DataItem itemC = node.removeItem();
        DataItem itemB = node.removeItem();
        Node child2 = node.disconnect(2);
        Node child3 = node.disconnect(3);

        Node right = new Node();
        right.insertItem(itemC);
        right.connect(0, child2);
        right.connect(1, child3);
        Node parent;
        if (node == root) {
            parent = new Node();
            root = parent;
            parent.insertItem(itemB);
            parent.insert(node);
        } else {
            parent = node.getParent();
            parent.insertItem(itemB);
        }
        parent.insert(right);
    }

    /** Reference split implementation (textbook). */
    @SuppressWarnings("unused")
    void split2(Node node) {
        DataItem itemC = node.removeItem();
        DataItem itemB = node.removeItem();
        Node child2 = node.disconnect(2);
        Node child3 = node.disconnect(3);

        Node right = new Node();
        Node parent;
        if (node == root) {
            root = new Node();
            parent = root;
            root.connect(0, node);
        } else {
            parent = node.getParent();
        }
        int itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--)  {
            Node temp = parent.disconnect(j);
            parent.connect(j + 1, temp);
        }

        parent.connect(itemIndex + 1, right);

        right.insertItem(itemC);
        right.connect(0, child2);
        right.connect(1, child3);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        recToString(builder, root, 0, 0);
        return builder.toString();
    }

    private void recToString(StringBuilder builder, Node node, int level, int childNumber) {
        builder.append("level=");
        builder.append(level);
        builder.append(" child=");
        builder.append(childNumber);
        builder.append(" ");
        builder.append(node.toString());
        builder.append(System.lineSeparator());
        int numNodes = node.getNumItems() + 1;
        for (int j = 0; j < numNodes; j++) {
            Node nextNode = node.getNode(j);
            if (nextNode != null) {
                recToString(builder, nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }

    public void display() {
        System.out.println(toString());
    }
}
