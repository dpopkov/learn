package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.ch07arrays.BinarySearch;
import learn.ijpds2nd.ch07arrays.LinearSearch;
import learn.ijpds2nd.tools.ConsoleInput;
import learn.ijpds2nd.tools.NanoStopWatch;

public class E0716ExecutionTime {
    private interface IntSearcher {
        int search(int[] array, int key);
    }

    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int size = in.requestInt("Enter size of array: ");
        int[] values = createArray(size);
        int[] keys = initQuarters(size);
        System.out.println("\nLinear Search");
        runSearchers(LinearSearch::linearSearch, values, keys);
        System.out.println("\nBinary Search");
        runSearchers(BinarySearch::binarySearch, values, keys);
    }

    private static int[] initQuarters(int arraySize) {
        int q25 = (int) (0.25 * arraySize);
        int q50 = (int) (0.50 * arraySize);
        int q75 = (int) (0.75 * arraySize);
        return new int[]{q25, q50, q75, arraySize};
    }

    private static void runSearchers(IntSearcher searcher, int[] a, int... keys) {
        NanoStopWatch sw = new NanoStopWatch();
        for (int key : keys) {
            sw.start();
            int idx = searcher.search(a, key);
            long e = sw.stop();
            System.out.printf("Value %9d found at index %9d in %d nanoseconds%n", key, idx, e);
        }
    }

    private static int[] createArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i + 1;
        }
        return a;
    }
}
