package learn.dsajg6e.ch11searchtrees;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch09pq2.Entry;

import java.util.Comparator;

/** An implementation of a sorted map using a red-black tree. */
public class RbTreeMap<K, V> extends TreeMap<K, V> {
    protected static final int BLACK = 0;
    protected static final int RED = 1;

    /** Constructs an empty map using the natural ordering of keys. */
    public RbTreeMap() {
        super();
    }

    /** Constructs an empty map using the given comparator to order keys. */
    public RbTreeMap(Comparator<K> comp) {
        super(comp);
    }

    /* The inherited aux field is used with convention that 0 = black and 1 = red
       (the new leaves will be black by default, as aux = 0). */

    private boolean isBlack(Position<Entry<K, V>> p) {
        return tree.getAux(p) == BLACK;
    }

    private boolean isRed(Position<Entry<K, V>> p) {
        return tree.getAux(p) == RED;
    }

    private void makeBlack(Position<Entry<K, V>> p) {
        tree.setAux(p, BLACK);
    }

    private void makeRed(Position<Entry<K, V>> p) {
        tree.setAux(p, RED);
    }

    private void setColor(Position<Entry<K, V>> p, boolean toRed) {
        tree.setAux(p, toRed ? RED : BLACK);
    }

    /** The re-balancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        if (!isRoot(p)) {
            makeRed(p);
            resolveRed(p);  // The inserted red node may cause a double-red problem
        }
    }

    /** Remedies potential double-red violation above red position p. */
    private void resolveRed(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> parent = parent(p);
        if (isRed(parent)) {
            Position<Entry<K, V>> uncle = sibling(parent);
            if (isBlack(uncle)) {                               // Case 1: mis-shaped 4-node
                Position<Entry<K, V>> middle = restructure(p);  // trinode restructuring
                makeBlack(middle);
                makeRed(left(middle));
                makeRed(right(middle));
            } else {                                            // Case 2: overfill 5-node
                makeBlack(parent);
                makeBlack(uncle);
                Position<Entry<K, V>> grand = parent(parent);
                if (!isRoot(grand)) {
                    makeRed(grand);
                    resolveRed(grand);
                }
            }
        }
    }

    /** The re-balancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (isRed(p)) {
            makeBlack(p);
        } else if (!isRoot(p)) {
            Position<Entry<K, V>> sib = sibling(p);
            if (isInternal(sib) & (isBlack(sib) || isInternal(left(sib)))) {
                remedyDoubleBlack(p);
            }
        }
    }

    /** Remedies a presumed double-black violation at the given (non-root) position. */
    private void remedyDoubleBlack(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> z = parent(p);
        Position<Entry<K, V>> y = sibling(p);
        if (isBlack(y)) {
            if (isRed(left(y)) || isRed(right(y))) {        // Case 1: trinode restructuring
                Position<Entry<K, V>> x = (isRed(left(y)) ? left(y) : right(y));
                Position<Entry<K, V>> middle = restructure(x);
                setColor(middle, isRed(z));
                makeBlack(left(middle));
                makeBlack(right(middle));
            } else {                                        // Case 2: recoloring
                makeRed(y);
                if (isRed(z)) {
                    makeBlack(z);           // problem is resolved
                } else if (!isRoot(z)) {
                    remedyDoubleBlack(z);   // propagate the problem
                }
            }
        } else {                                            // Case 3: reorient 3-node
            rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(p);           // restart the process at p
        }
    }
}
