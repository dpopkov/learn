package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.ch09pq2.HeapPriorityQueue;

/**
 * C-9.29, C-9.30
 * Contains alternative implementation of {@link #upHeap(int)} and {@link #downHeap(int)} methods that uses recursion.
 */
public class C0929HeapPriorityQueueRecursion<K, V> extends HeapPriorityQueue<K, V> {
    @Override
    protected void upHeap(int j) {
        upHeadRecursive(j);
    }

    @Override
    protected void downHeap(int j) {
        downHeapRecursive(j);
    }

    private void upHeadRecursive(int j) {
        if (j == 0) {
            return;
        }
        int p = parent(j);
        if (compare(heap.get(p), heap.get(j)) <= 0) {
            return;
        }
        swap(p, j);
        upHeadRecursive(p);
    }

    private void downHeapRecursive(int j) {
        if (!hasLeft(j)) {
            return;
        }
        System.out.printf("downHeapRecursive %s at %d%n", heap.get(j), j);
        int c = left(j);
        if (hasRight(j)) {
            int r = right(j);
            if (compare(heap.get(r), heap.get(c)) < 0) {
                c = r;
            }
        }
        if (compare(heap.get(c), heap.get(j)) >= 0) {
            return;
        }
        swap(j, c);
        downHeapRecursive(c);
    }
}
