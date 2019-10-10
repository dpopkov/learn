package learn.dsajg6e.ch09pq2.exer;

public class C0939LongPriorityQueue implements LongPriorityQueue {
    public static final LongBiPredicate MINIMUM_ORIENTED = (a, b) -> a <= b;
    public static final LongBiPredicate MAXIMUM_ORIENTED = (a, b) -> a >= b;

    private final long[] heap;
    private int size;
    private final LongBiPredicate heapOrder;

    public C0939LongPriorityQueue(int capacity) {
        this(MINIMUM_ORIENTED, capacity);
    }

    public C0939LongPriorityQueue(LongBiPredicate heapOrder, int capacity) {
        this.heapOrder = heapOrder;
        heap = new long[capacity];
    }

    @Override
    public void insert(long key) {
        if (size == heap.length) {
            throw new IllegalStateException("The priority queue is full");
        }
        heap[size] = key;
        size++;
        upHeap(size - 1);
    }

    private void upHeap(int i) {
        while (i > 0) {
            int p = parent(i);
            if (heapOrder.test(heap[p], heap[i])) {
                break;
            }
            swap(p, i);
            i = p;
        }
    }

    @Override
    public long min() {
        if (size == 0) {
            throw new IllegalStateException("The priority queue is empty");
        }
        return heap[0];
    }

    @Override
    public long removeMin() {
        if (size == 0) {
            throw new IllegalStateException("The priority queue is empty");
        }
        long value = heap[0];
        swap(0, --size);
        downHeapFromRoot();
        return value;
    }

    private void downHeapFromRoot() {
        int i = 0;
        while (i < size) {
            int left = left(i);
            if (left >= size) {
                break;
            }
            int smallest = left;
            int right = right(i);
            if (right < size) {
                if (heapOrder.test(heap[right], heap[left])) {
                    smallest = right;
                }
            }
            if (heapOrder.test(heap[i], heap[smallest])) {
                break;
            }
            swap(i, smallest);
            i = smallest;
        }
    }

    private int parent(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("This index has not parent: " + i);
        }
        return (i - 1) / 2;
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private void swap(int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
