package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

import java.util.Arrays;

public class E0715EliminateDuplicates {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.inputSizeAndArray();
        System.out.println("Before:");
        System.out.println(Arrays.toString(a));
        int[] b = removeDupes(a);
        System.out.println("After :");
        System.out.println(Arrays.toString(b));
    }

    static int[] removeDupes(int[] array) {
        int[] buffer = new int[array.length];
        int i = 0;
        for (int value : array) {
            if (!contains(buffer, value)) {
                buffer[i++] = value;
            }
        }
        return Arrays.copyOf(buffer, i);
    }

    private static boolean contains(int[] a, int n) {
        for (int i : a) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }
}
