package learn.dsajg6e.ch09priorityqueues.exer;

import learn.dsajg6e.ch07list.positional.Position;
import learn.dsajg6e.ch09priorityqueues.Entry;
import learn.dsajg6e.ch09priorityqueues.PQEntry;
import learn.dsajg6e.ch09priorityqueues.UnsortedPriorityQueue;

public class R0905FastUnsortedPriorityQueue<K, V> extends UnsortedPriorityQueue<K, V> {
    private Position<Entry<K, V>> minPos;

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        if (isEmpty()) {
            minPos = list.addLast(newest);
        } else if (compare(newest, minPos.getElement()) < 0) {
            minPos = list.addLast(newest);
        } else {
            list.addLast(newest);
        }
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        }
        return minPos.getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        Entry<K, V> result = minPos.getElement();
        list.remove(minPos);
        minPos = findMin();
        return result;
    }
}
