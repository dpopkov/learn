package learn.dsajg6e.ch01primer.exer;

import java.util.Arrays;

public class C0123DotProduct {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] c = dotProduct(a, b);
        System.out.println(Arrays.toString(c));
    }

    private static int[] dotProduct(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b[i];
        }
        return c;
    }
}
