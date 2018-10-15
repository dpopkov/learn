package learn.csia.ch0104.exer;

import java.util.Arrays;

public class E010408Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i - 2] + a[i - 1];
        }
        System.out.println(Arrays.toString(a));
    }
}
