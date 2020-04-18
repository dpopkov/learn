package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

import java.util.Arrays;

public class E0731MergeSortedArrays {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.inputIntArray("Enter 1st list:");
        int[] b = in.inputIntArray("Enter 2nd list:");
        int[] r = merge(a, b);
        System.out.println("The merged list is");
        System.out.println(Arrays.toString(r));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < r.length; k++) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    r[k] = a[i++];
                } else {
                    r[k] = b[j++];
                }
            } else if (i < a.length) {
                r[k] = a[i++];
            } else {
                r[k] = b[j++];
            }
        }
        return r;
    }
}
