package learn.dsajg6e.ch11searchtrees;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch09pq2.Entry;

import java.util.Comparator;

/** An implementation of a sorted map using an AVL tree. */
public class AvlTreeMap<K, V> extends TreeMap<K, V> {

    /** Constructs an empty map using the natural ordering of keys. */
    public AvlTreeMap() {
        super();
    }

    /** Constructs an empty map using the given comparator to order keys. */
    public AvlTreeMap(Comparator<K> comparator) {
        super(comparator);
    }

    /** Returns the height of the given tree position. */
    protected int height(Position<Entry<K, V>> p) {
        return tree.getAux(p);
    }

    /** Recomputes the height of the given position based on its children's heights. */
    protected void recomputeHeight(Position<Entry<K, V>> p) {
        tree.setAux(p, 1 + Math.max(height(left(p)), height(right(p))));
    }

    /** Returns whether a position has balance factor between -1 and 1 inclusive. */
    protected boolean isBalanced(Position<Entry<K, V>> p) {
        return Math.abs(height(left(p)) - height(right(p))) <= 1;
    }

    /** Returns a child of p with height no smaller than that of the other child. */
    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
        var leftChild = left(p);
        var rightChild = right(p);
        int leftHeight = height(leftChild);
        int rightHeight = height(rightChild);
        if (leftHeight > rightHeight) {
            return leftChild;
        }
        if (leftHeight < rightHeight) {
            return rightChild;
        }
        // equal height children; break the tie while matching parent's orientation
        if (isRoot(p)) {
            return leftChild;
        }
        // return aligned child
        return p == left(parent(p)) ? leftChild : rightChild;
    }

    /**
     * Utility used to rebalance after an insert or removal operation. This traverses the
     * path upward from p, performing a trinode restructuring when imbalance is found,
     * continuing until balance is restored.
     */
    protected void rebalance(Position<Entry<K, V>> p) {
        int oldHeight;
        int newHeight;
        do {
            oldHeight = height(p);
            if (!isBalanced(p)) {
                p = restructure(tallerChild(tallerChild(p)));
                recomputeHeight(left(p));
                recomputeHeight(right(p));
            }
            recomputeHeight(p);
            newHeight = height(p);
            p = parent(p);
        } while (oldHeight != newHeight && p != null);
    }

    /** Overrides the TreeMap re-balancing hook that is called after an insertion. */
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    /** Overrides the TreeMap re-balancing hook that is called after a deletion. */
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p)) {
            rebalance(parent(p));
        }
    }
}
