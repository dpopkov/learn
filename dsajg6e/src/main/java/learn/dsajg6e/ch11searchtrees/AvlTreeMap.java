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
}
