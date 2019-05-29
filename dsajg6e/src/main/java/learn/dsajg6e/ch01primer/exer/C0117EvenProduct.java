package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.RandomArrays;

import java.util.Arrays;

/**
 * Determines if there is a pair of distinct elements in the array whose product is even.
 */
public class C0117EvenProduct {
    public static void main(String[] args) {
        int[] a = RandomArrays.makeInt(10, 40);
        System.out.println(Arrays.toString(a));
        findEvenProducts(a);
    }

    private static void findEvenProducts(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                int p = a * b;
                if (p % 2 == 0) {
                    System.out.printf("arr[%d] * arr[%d] = %d * %d = %d - Even product found!%n", i, j, a, b, p);
                }
            }
        }
    }
}
