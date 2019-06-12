package learn.dsajg6e.ch03fund.exer;

import java.util.Arrays;
import java.util.Random;

public class R0302RemoveRandom {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        System.out.println(Arrays.toString(a));
        int n;
        do {
            n = removeRandom(a);
            System.out.println(Arrays.toString(a));
        } while (n > 0);
    }

    /**
     * Removes random element from the array replacing it with null
     * @param a array
     * @param <T> type of elements
     * @return number of non null elements in the array
     */
    @SuppressWarnings("ManualArrayCopy")
    private static <T> int removeRandom(T[] a) {
        int last = a.length - 1;
        while (a[last] == null) {
            last--;
        }
        int idx = random.nextInt(last + 1);
        for (int i = idx; i < last; i++) {
            a[i] = a[i + 1];
        }
        a[last] = null;
        return last;
    }
}
