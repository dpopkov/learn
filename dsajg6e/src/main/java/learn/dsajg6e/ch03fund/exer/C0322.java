package learn.dsajg6e.ch03fund.exer;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Contains method shuffle(A), that rearranges the elements of array A so that every
 * possible ordering is equally likely.
 */
public class C0322 {
    private static final Random random = new Random();
    private static final int SIZE = 9;

    public static void main(String[] args) {
        Map<Integer, int[]> stats = new TreeMap<>();
        int numTests = 100;
        if (args.length == 1) {
            numTests = Integer.parseInt(args[0]);
        }
        int[] a = new int[SIZE];
        for (int j = 0; j < numTests; j++) {
            fill(a);
            shuffle(a);
            gatherStats(stats, a);
        }
        System.out.println("Statistics:");
        stats.forEach((k, v) -> System.out.printf("%d : %s%n", k, Arrays.toString(v)));
    }

    private static void gatherStats(Map<Integer, int[]> stats, int[] randoms) {
        for (int i = 0; i < randoms.length; i++) {
            int key = randoms[i];
            int[] stat = stats.get(key);
            if (stat == null) {
                stat = new int[SIZE];
                stat[i] = 1;
                stats.put(key, stat);
            } else {
                stat[i] = stat[i] + 1;
            }
        }
    }

    private static void fill(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int digit = i + 1;
            int key = digit * 10 + digit;
            a[i] = key;
        }
    }

    private static void shuffle(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int j = i + random.nextInt(a.length - i);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
