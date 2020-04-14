package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

import java.util.Arrays;

public class E0714LeastCommonMultiple {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.inputSizeAndArray();
        int lcm = findLeastCommonMultiple(a);
        System.out.println("least common multiple = " + lcm);
    }

    /** Brute force solution for finding the least common multiplier. */
    static int findLeastCommonMultiple(int[] a) {
        int[] a2 = Arrays.copyOf(a, a.length);
        Arrays.sort(a2);
        int[] m = Arrays.copyOf(a2, a2.length);
        int last = m.length - 1;
        while (!allEqual(m)) {
            for (int i = 0; i < m.length; i++) {
                if (i < last && m[i] < m[i + 1] || i > 0 && m[i - 1] > m[i]) {
                    m[i] += a2[i];
                    if (allEqual(m)) {
                        return m[0];
                    }
                }
            }
        }
        throw new IllegalStateException();
    }

    private static boolean allEqual(int[] a) {
        int n = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] != n) {
                return false;
            }
        }
        return true;
    }
}
