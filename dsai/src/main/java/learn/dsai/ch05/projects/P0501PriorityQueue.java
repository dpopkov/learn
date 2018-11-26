package learn.dsai.ch05.projects;

import learn.dsai.ch05.adt.sorted.SortedList;

/**
 * Priority queue based on a sorted linked list
 * and stores values of type {@code long}.
 */
public class P0501PriorityQueue {
    private final SortedList list = new SortedList();

    public void add(long data) {
        list.insert(data);
    }

    public long remove() {
        return list.remove();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
