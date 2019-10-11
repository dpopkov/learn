package learn.dsajg6e.ch09pq2.exer;

import learn.dsajg6e.tools.Input;
import learn.dsajg6e.tools.RandomArrays;
import learn.dsajg6e.tools.StopWatch;

/**
 * Example of how the k largest elements from an unordered collection of size n
 * can be found in time O(n + k*log(n)) using a maximum-oriented heap.
 */
public class C0939LargestElements {
    public static void main(String[] args) {
        int numTests = Input.optionalIntArgument(args, 0, "Enter number of tests: ");
        int size = Input.optionalIntArgument(args, 1, "Enter size of the collection: ");
        int numLargest = Input.optionalIntArgument(args, 2, "Enter number of largest elements: ");
        long[] values = RandomArrays.makeLong(size, size * 10);

        StopWatch sw = new StopWatch();
        sw.start();
        for (int j = 0; j < numTests; j++) {
            LongPriorityQueue queue = new C0939LongPriorityQueue(LongPriorityQueue.MAXIMUM_ORIENTED, values);
            for (int i = 0; i < numLargest; i++) {
                queue.removeMin();
            }
        }
        sw.stop();
        System.out.println("Elapsed time ms: " + sw.getElapsed());
    }
}
