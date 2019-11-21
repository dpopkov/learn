package learn.dsajg6e.ch11searchtrees;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch09pq2.Entry;

import java.util.Comparator;

/** An implementation of a sorted map using a splay tree. */
public class SplayTreeMap<K, V> extends TreeMap<K, V> {
    /** Constructs an empty map using the natural ordering of keys. */
    public SplayTreeMap() {
        super();
    }

    /** Constructs an empty map using the given comparator to order keys. */
    public SplayTreeMap(Comparator<K> comparator) {
        super(comparator);
    }

    /** Utility used to rebalance after a map operation. */
    private void splay(Position<Entry<K, V>> p) {
        while (!isRoot(p)) {
            Position<Entry<K, V>> parent = parent(p);
            Position<Entry<K, V>> grand = parent(parent);
            if (grand == null) {
                rotate(p);
            } else if ((parent == left(grand)) == (p == left(parent))) {
                rotate(parent);
                rotate(p);
            } else {
                rotate(p);
                rotate(p);
            }
        }
    }

    @Override
    protected void rebalanceAccess(Position<Entry<K, V>> p) {
        if (isExternal(p)) {
            p = parent(p);
        }
        if (p != null) {
            splay(p);
        }
    }

    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        splay(p);
    }

    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p)) {
            splay(parent(p));
        }
    }
}
