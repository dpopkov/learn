package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.RandomArrays;

import java.util.Arrays;

public class C0115MinMax {
    public static void main(String[] args) {
        int[] a = RandomArrays.makeInt(7, 100);
        System.out.println(Arrays.toString(a));
        int mn = min(a);
        int mx = max(a);
        System.out.println("min = " + mn);
        System.out.println("max = " + mx);
    }

    private static int max(int[] a) {
        int m = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > m) {
                m = i;
            }
        }
        return m;
    }

    private static int min(int[] a) {
        int m = Integer.MAX_VALUE;
        for (int i : a) {
            if (i < m) {
                m = i;
            }
        }
        return m;
    }
}
