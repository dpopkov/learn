package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.tools.Input;
import learn.dsajg6e.tools.RandomArrays;
import learn.dsajg6e.tools.StopWatch;

import java.util.Arrays;

public class P0950HeapSortInPlace {

    static class MaxLongHeap {
        private final long[] values;
        private int size;

        public MaxLongHeap(long[] values) {
            this.values = values;
            size = values.length;
            build();
        }

        public long removeMax() {
            long max = values[0];
            values[0] = values[--size];
            downHeap(0);
            return max;
        }

        private void build() {
            int p = parent(size - 1);
            while (p >= 0) {
                downHeap(p);
                p--;
            }
        }

        private void downHeap(int i) {
            while (i < size) {
                int left = left(i);
                if (left < size) {
                    int big = left;
                    int right = right(i);
                    if (right < size && values[big] < values[right]) {
                        big = right;
                    }
                    if (values[big] <= values[i]) {
                        break;
                    }
                    swap(big, i);
                    i = big;
                } else {
                    break;
                }
            }
        }

        private void swap(int j, int i) {
            long temp = values[j];
            values[j] = values[i];
            values[i] = temp;
        }

        private int left(int i) {
            return i * 2 + 1;
        }

        private int right(int i) {
            return i * 2 + 2;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }
    }

    public void sort(long[] values) {
        MaxLongHeap heap = new MaxLongHeap(values);
        for (int i = values.length - 1; i >= 0; i--) {
            long max = heap.removeMax();
            values[i] = max;
        }
    }

    public void sortNotInPlace(long[] values) {
        C0939LongPriorityQueue queue = new C0939LongPriorityQueue(values);
        for (int i = 0; i < values.length; i++) {
            values[i] = queue.removeMin();
        }
    }

    public static void main(String[] args) {
        int numTests = Input.optionalIntArgument(args, 0, "Enter number of tests: ");
        int size = Input.optionalIntArgument(args, 1, "Enter size of data: ");
        StopWatch sw1 = new StopWatch();
        StopWatch sw2 = new StopWatch();
        long elapsed1 = 0;
        long elapsed2 = 0;
        for (int i = 0; i < numTests; i++) {
            long[] values = RandomArrays.makeLong(size, size * 2);
            long[] data1 = Arrays.copyOf(values, values.length);
            long[] data2 = Arrays.copyOf(values, values.length);
            P0950HeapSortInPlace sorter = new P0950HeapSortInPlace();

            sw1.start();
            sorter.sort(data1);
            sw1.stop();
            elapsed1 += sw1.getElapsed();
            sw2.start();
            sorter.sortNotInPlace(data2);
            sw2.stop();
            elapsed2 += sw2.getElapsed();
        }
        System.out.println("elapsed1 = " + elapsed1);
        System.out.println("elapsed2 = " + elapsed2);
    }
}
