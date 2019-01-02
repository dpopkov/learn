package learn.dsai.ch10tree234;

public class Node {
    private static final int ORDER = 4;
    private static final int MAX_ITEMS = ORDER - 1;

    private int numItems;
    private Node parent;
    private final Node[] nodes = new Node[ORDER];
    private final DataItem[] items = new DataItem[MAX_ITEMS];

    public void connect(int nodeIndex, Node node) {
        nodes[nodeIndex] = node;
        if (node != null) {
            node.parent = this;
        }
    }

    public Node disconnect(int nodeIndex) {
        Node node = nodes[nodeIndex];
        nodes[nodeIndex] = null;
        return node;
    }

    /**
     * Inserts the node according to order of the existing items.
     * @param node node to insert
     */
    public void insert(Node node) {
        int i = numItems - 1;
        while (i >= 0
                && items[i].getData() > node.getItem(0).getData()) {
            i--;
        }
        connect(i + 1, node);
//        nodes[i + 1] = node;
    }

    public Node getNode(int index) {
        return nodes[index];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return nodes[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return items[index];
    }

    public boolean isFull() {
        return numItems == MAX_ITEMS;
    }

    /** Returns index of item. */
    public int findItem(long key) {
        int index = -1;
        for (int i = 0; i < items.length && items[i] != null; i++) {
            if (items[i].getData() == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    /** Inserts item to non full node. */
    public int insertItem(DataItem item) {
        int j = numItems;
        while (j > 0 && items[j - 1].getData() > item.getData()) {
            items[j] = items[j - 1];
            j--;
        }
        items[j] = item;
        numItems++;
        return j;
    }

    /** Removes largest item from non empty node. */
    public DataItem removeItem() {
        int idx = --numItems;
        DataItem item = items[idx];
        items[idx] = null;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numItems; i++) {
            builder.append(items[i].toString());
        }
        builder.append("/");
        return builder.toString();
    }

    public static Node of(Long... values) {
        if (values.length > 3) {
            throw new IllegalArgumentException();
        }
        Node n = new Node();
        for (Long v : values) {
            n.insertItem(new DataItem(v));
        }
        return n;
    }
}
