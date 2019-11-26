package learn.dsajg6e.ch11searchtrees.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch11searchtrees.TreeMap;

/**
 * Contains non-recursive implementation of {@link #treeSearch(Position, Object)} method.
 */
public class R1106TreeMap<K, V> extends TreeMap<K, V> {
    @Override
    protected Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        while (!isExternal(p)) {
            int comp = compare(key, p.getElement());
            if (comp == 0) {
                break;   // key found
            } else if (comp < 0) {
                p = left(p);
            } else {
                p = right(p);
            }
        }
        return p;
    }
}
