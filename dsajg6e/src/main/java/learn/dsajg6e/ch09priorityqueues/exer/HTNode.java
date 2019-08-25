package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.Entry;

/** A Node for heap linked tree. */
class HTNode<K, V> {
    private Entry<K, V> entry;
    private HTNode<K, V> parent;
    private HTNode<K, V> left;
    private HTNode<K, V> right;

    public HTNode(Entry<K, V> entry) {
        this(entry, null, null, null);
    }

    public HTNode(Entry<K, V> entry, HTNode<K, V> parent, HTNode<K, V> left, HTNode<K, V> right) {
        this.entry = entry;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public void add(HTNode<K, V> n) {
        if (left == null) {
            left = n;
        } else if (right == null) {
            right = n;
        } else {
            throw new IllegalStateException("This node has no empty slots: " + this);
        }
        n.setParent(this);
    }

    public boolean isRight(HTNode<K, V> child) {
        return right == child;
    }

    public boolean isLeft(HTNode<K ,V> child) {
        return left == child;
    }

    public boolean isLeftChild() {
        HTNode<K, V> parent = getParent();
        return parent != null && parent.getLeft() == this;
    }

    public void removeChild(HTNode<K, V> child) {
        if (isRight(child)) {
            right = null;
        } else if (isLeft(child)) {
            left = null;
        } else {
            throw new IllegalStateException("This node is not a child: " + child);
        }
        child.setParent(null);
    }

    public Entry<K, V> getEntry() {
        return entry;
    }

    public void setEntry(Entry<K, V> entry) {
        this.entry = entry;
    }

    public HTNode<K, V> getParent() {
        return parent;
    }

    public void setParent(HTNode<K, V> parent) {
        this.parent = parent;
    }

    public HTNode<K, V> getLeft() {
        return left;
    }

    public HTNode<K, V> getRight() {
        return right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void swapEntries(HTNode<K, V> other) {
        Entry<K, V> otherEntry = other.getEntry();
        other.setEntry(this.getEntry());
        this.setEntry(otherEntry);
    }

    @Override
    public String toString() {
        return "Node{entry=" + entry + '}';
    }
}
