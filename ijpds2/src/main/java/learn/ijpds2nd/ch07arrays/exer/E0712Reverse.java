package learn.ijpds2nd.ch07arrays.exer;

import java.util.Arrays;
import java.util.Scanner;

public class E0712Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        reverse(a);
        System.out.println(Arrays.toString(a));
    }

    private static void reverse(int[] a) {
        int j = a.length - 1;
        for (int i = 0; i < j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
