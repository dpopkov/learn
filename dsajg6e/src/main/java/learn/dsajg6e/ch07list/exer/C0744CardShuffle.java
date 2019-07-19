package learn.dsajg6e.ch07list.exer;

import java.util.Arrays;

public class C0744CardShuffle {
    static void shuffle(long[] values) {
        long[] a1 = Arrays.copyOf(values, values.length / 2);
        long[] a2 = Arrays.copyOfRange(values, values.length / 2, values.length);
        for (int i = 0, j = 0; i < a1.length; i++) {
            values[j++] = a1[i];
            values[j++] = a2[i];
        }
    }

    public static void main(String[] args) {
        long[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        shuffle(a);
        System.out.println(Arrays.toString(a));
    }
}
