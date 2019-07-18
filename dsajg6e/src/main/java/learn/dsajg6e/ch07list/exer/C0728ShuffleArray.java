package learn.dsajg6e.ch07list.exer;

import learn.dsajg6e.tools.Input;

import java.util.*;

public class C0728ShuffleArray {
    public static final int NUM_POSITIONS = 10;
    private static final Random RANDOM = new Random();

    static void shuffle(long[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            if (i != j) {
                long tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int numTests = getNumTests(args);
        System.out.println("Using number of tests: " + numTests);
        Map<Long, int[]> stats = initStats();
        long[] values = new long[NUM_POSITIONS];
        for (int i = 0; i < numTests; i++) {
            fillValues(values);
            shuffle(values);
            fillStats(stats, values);
        }
        display(stats);
    }

    private static int getNumTests(String[] args) {
        int numTests = -1;
        if (args.length == 1) {
            try {
                numTests = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid argument: " + args[0]);
                System.out.println("Using manual input.");
            }
        }
        if (numTests == -1) {
            numTests = Input.nextInt("Enter number of tests: ");
        }
        return numTests;
    }

    private static void display(Map<Long, int[]> stats) {
        stats.forEach((k, v) -> System.out.printf("%2d : %s%n", k, Arrays.toString(v)));
    }

    private static void fillStats(Map<Long, int[]> stats, long[] array) {
        for (int i = 0; i < array.length; i++) {
            long value = array[i];
            int[] frequency = stats.get(value);
            frequency[i]++;
        }
    }

    private static void fillValues(long[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
    }

    private static Map<Long, int[]> initStats() {
        Map<Long, int[]> stats = new TreeMap<>();
        for (long i = 0; i < NUM_POSITIONS; i++) {
            stats.put(i, new int[NUM_POSITIONS]);
        }
        return stats;
    }
}
