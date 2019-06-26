package learn.dsajg6e.ch05recursion.exer;

import learn.dsajg6e.tools.RandomArrays;

import java.util.Arrays;

public class R0501Maximum {
    public static int maximum(int[] data, int n) {
        if (n == 1) {
            return data[0];
        }
        int m = n - 1;
        return Math.max(maximum(data, m), data[m]);
    }

    public static void main(String[] args) {
        int[] arr = RandomArrays.makeInt(10, 20);
        System.out.println(Arrays.toString(arr));
        System.out.println("maximum(arr, arr.length) = " + maximum(arr, arr.length));
    }
}
