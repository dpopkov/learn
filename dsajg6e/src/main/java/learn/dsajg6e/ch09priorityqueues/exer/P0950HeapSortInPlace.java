package learn.dsajg6e.ch09priorityqueues.exer;

public class P0950HeapSortInPlace<E extends Comparable<E>> {
    private final E[] values;

    public P0950HeapSortInPlace(E[] values) {
        this.values = values;
    }

    public void sort() {
        buildHeapInPlace();
        restoreFromHeap();
    }

    private void buildHeapInPlace() {
        for (int b = 1; b < values.length; b++) {
            upHeapFrom(b);
        }
    }

    /** Restores Heap condition beginning from the specified index. */
    private void upHeapFrom(int child) {
        while (child != 0) {
            int parent = (child - 1) / 2;
            if (values[parent].compareTo(values[child]) < 0) {
                swap(values, parent, child);
            }
            child = parent;
        }
    }

    private void restoreFromHeap() {
        for (int j = values.length - 1; j >= 0; j--) {
            swap(values, 0, j);
            downHeapTo(j);
        }
    }

    private void downHeapTo(int limit) {
        int j = 0;
        while (j < limit) {
            int left = j * 2 + 1;
            if (left >= limit) {
                break;
            }
            int right = j * 2 + 2;
            int target;
            if (right >= limit) {
                target = left;
            } else {
                if (values[left].compareTo(values[right]) > 0) {
                    target = left;
                } else {
                    target = right;
                }
            }
            if (values[j].compareTo(values[target]) < 0) {
                swap(values, j, target);
                j = target;
            } else {
                break;
            }
        }
    }

    private void swap(E[] values, int i, int j) {
        E tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
