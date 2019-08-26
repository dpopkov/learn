package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch09priorityqueues.Entry;
import learn.dsajg6e.ch09priorityqueues.PQEntry;

import java.util.ArrayList;
import java.util.List;

/*
Given a heap H and a key k, give an algorithm to compute all the entries in H
having a key less than or equal to k.
 */
public class C0934FindEntries<K, V> extends C0931HeapLinkedTreePQueue<K, V> {

    public List<Entry<K, V>> findBefore(K limit) {
        List<Entry<K, V>> found = new ArrayList<>();
        final PQEntry<K, V> limitEntry = new PQEntry<>(limit, null);
        walkPreOrder(root, limitEntry, found);
        return found;
    }

    private void walkPreOrder(HTNode<K, V> node, final Entry<K, V> limit, List<Entry<K, V>> found) {
        if (node != null && compare(node.getEntry(), limit) <= 0) {
            found.add(node.getEntry());
            walkPreOrder(node.getLeft(), limit, found);
            walkPreOrder(node.getRight(), limit, found);
        }
    }

    public void insert(K key) throws IllegalArgumentException {
        super.insert(key, null);
    }
}
