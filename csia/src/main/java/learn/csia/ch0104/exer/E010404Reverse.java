package learn.csia.ch0104.exer;

import java.util.Arrays;

public class E010404Reverse {
    public static void main(String[] args) {
        String[] a = {"one", "two", "three"};
        reverse(a);
        System.out.println(Arrays.toString(a));
    }

    private static void reverse(String[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            String t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
