package learn.dsajg6e.ch11searchtrees;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch08trees.LinkedBinaryTree;
import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.AbstractSortedMap;

/**
 * An implementation of a sorted map using a binary search tree.
 */
public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
    protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {
        protected void rotate(Position<Entry<K, V>> p) {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        protected Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }

    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    public TreeMap() {
        super();
        tree.addRoot(null);
    }

    /** Returns the number of entries in the map. */
    @Override
    public int size() {
        return (tree.size() - 1) / 2;   // only internal nodes have entries
    }

    /** Utility used when inserting a new entry at a leaf of the tree. */
    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }

    /*
    Protected utilities that serve as shorthands for brevity (yet not efficiency).
    These utilities wrap operations on the underlying linked binary tree.
    */

    protected Position<Entry<K, V>> root() {
        return tree.root();
    }

    protected Position<Entry<K ,V>> parent(Position<Entry<K ,V>> p) {
        return tree.parent(p);
    }

    protected Position<Entry<K ,V>> left(Position<Entry<K ,V>> p) {
        return tree.left(p);
    }

    protected Position<Entry<K ,V>> right(Position<Entry<K ,V>> p) {
        return tree.right(p);
    }

    protected Position<Entry<K ,V>> sibling(Position<Entry<K ,V>> p) {
        return tree.sibling(p);
    }

    protected boolean isRoot(Position<Entry<K,V>> p) {
        return tree.isRoot(p);
    }

    protected boolean isExternal(Position<Entry<K,V>> p) {
        return tree.isExternal(p);
    }

    protected boolean isInternal(Position<Entry<K,V>> p) {
        return tree.isInternal(p);
    }

    protected void set(Position<Entry<K,V>> p, Entry<K,V> e) {
        tree.set(p, e);
    }

    protected Entry<K,V> remove(Position<Entry<K,V>> p) {
        return tree.remove(p);
    }

    protected void rotate(Position<Entry<K,V>> p) {
        tree.rotate(p);
    }

    protected Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) {
        return tree.restructure(x);
    }

    /** Returns the position in p's subtree having given key (or else the terminal leaf). */
    private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        if (isExternal(p)) {
            return p;   // not found
        }
        int comp = compare(key, p.getElement());
        if (comp == 0) {
            return p;   // key found
        } else if (comp < 0) {
            return treeSearch(left(p), key);
        } else {
            return treeSearch(right(p), key);
        }
    }

    /** Returns the value associated with the specified key (or else null). */
    @Override
    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        rebalanceAccess(p);
        if (isExternal(p)) {
            return null;
        }
        return p.getElement().getValue();
    }

    /** Associates the given value with the given key, returning any overridden value. */
    @Override
    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        V old = null;
        if (isExternal(p)) {
            expandExternal(p, newEntry);
            rebalanceInsert(p);
        } else {
            old = p.getElement().getValue();
            set(p, newEntry);
            rebalanceAccess(p);
        }
        return old;
    }

    /** Removes the entry having key k (if any) and returns its associated value. */
    @Override
    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        V old = null;
        if (isExternal(p)) {    // key not found
            rebalanceAccess(p);
        } else {
            old = p.getElement().getValue();
            if (isInternal(left(p)) && isInternal(right(p))) {
                Position<Entry<K, V>> replacement = treeMax(left(p));
                set(p, replacement.getElement());
                p = replacement;
            }
            Position<Entry<K, V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
            Position<Entry<K, V>> sib = sibling(leaf);
            remove(leaf);
            remove(p);
            rebalanceDelete(sib);
        }
        return old;
    }

    /** Returns the position with the maximum key in subtree rooted at the specified position. */
    private Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> walk = p;
        while (isInternal(walk)) {
            walk = right(walk);
        }
        return parent(walk);
    }

    /** Return the entry having the greatest key (or null if map is empty). */
    @Override
    public Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return treeMax(root()).getElement();
    }

    /** Returns the entry having the greatest key less than or equal to the given key (if any). */
    @Override
    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p)) {
            return p.getElement();
        }
        // todo: test this logic !!! (I'm not sure about the "else" part)
        while (!isRoot(p)) {
            if (p == right(parent(p))) {
                return parent(p).getElement();
            } else {
                p = parent(p);
            }
        }
        return null;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) {
        // todo: implement when the rest of the code is in place
        return null;
    }

    @Override
    public Entry<K, V> firstEntry() {
        return null;
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return null;
    }

    @Override
    public Entry<K, V> higherEntry(K key) {
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> subMap(K key1, K key2) {
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }

    /*
        Trivial definitions of TreeMap methods that serve as hooks
        for a re-balancing framework. These methods may be overridden by subclasses
        in order to perform appropriate re-balancing operations.
     */

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        // the body of the method does nothing
    }

    protected void rebalanceAccess(Position<Entry<K, V>> p) {
        // the body of the method does nothing
    }

    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        // the body of the method does nothing
    }
}
