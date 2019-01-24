package learn.dsai.ch10tree234.projects;

public class Node23<E extends Comparable<? super E>> {
    private static final int ORDER = 3;
    private static final int MAX_ITEMS = ORDER - 1;
    private static final int MAX_NODES = ORDER;

    private E[] items;
    private int numItems;
    private Node23<E> parent;
    private Node23<E>[] nodes;

    @SuppressWarnings("unchecked")
    public Node23() {
        items = (E[]) new Comparable[MAX_ITEMS];
        nodes = (Node23<E>[]) new Node23[MAX_NODES];
    }

    Node23(E value) {
        this();
        insert(value);
    }

    Node23(E value1, E value2) {
        this();
        insert(value1);
        insert(value2);
    }

    public Node23<E> getParent() {
        return parent;
    }

    public E getItem(int i) {
        if (i >= numItems) {
            throw new IllegalArgumentException(String.format("Index %d >= number of items %d", i, numItems));
        }
        return items[i];
    }

    public E squeezeMiddleValue(E newValue) {
        E middle = newValue;
        if (items[0].compareTo(newValue) > 0) {
            middle = items[0];
            items[0] = newValue;
        } else if (items[1].compareTo(newValue) < 0) {
            middle = items[1];
            items[1] = newValue;
        }
        return middle;
    }

    public E removeItem(int i) {
        if (i >= numItems) {
            throw new IllegalArgumentException(String.format("Index %d >= number of items %d", i, numItems));
        }
        E item = items[i];
        items[i] = null;
        numItems--;
        return item;
    }

    public void insert(E value) {
        if (numItems == 1 && items[0].compareTo(value) > 0) {
            items[1] = items[0];
            items[0] = value;
        } else {
            items[numItems] = value;
        }
        numItems++;
    }

    public boolean isLeaf() {
        return nodes[0] == null;
    }

    public boolean isFull() {
        return numItems == items.length;
    }

    public E lastItem() {
        return items[numItems - 1];
    }

    public void connect(Node23<E> subNode) {
        for (int i = 0; i < numItems; i++) {
            if (items[i].compareTo(subNode.lastItem()) > 0) {
                connect(i, subNode);
                return;
            }
        }
        connect(numItems, subNode);
    }

    public void connect(int index, Node23<E> subNode) {
        nodes[index] = subNode;
        subNode.parent = this;
    }

    public Node23<E> getNode(int index) {
        return nodes[index];
    }

    public Node23<E> findNext(E valueToInsert) {
        for (int i = 0; i < numItems; i++) {
            if (items[i].compareTo(valueToInsert) > 0) {
                return nodes[i];
            }
        }
        return nodes[numItems];
    }
}
