package learn.dsajg6e.ch04analysis;

import learn.dsajg6e.tools.Input;

import java.util.Arrays;
import java.util.function.Function;

/*
  size     #1    #2
  -----------------
 10000     17     1
 20000     50     1
 40000    179     2
 80000    726     4
160000   2945     6
 */
public class ExperimentsUnique {
    public static void main(String[] args) {
        int size = Input.nextInt("Enter size:");
        test(1, size, ExperimentsUnique::unique1);
        test(2, size, ExperimentsUnique::unique2);
    }

    private static void test(int id, int size, Function<int[], Boolean> function) {
        int[] arr = make(size);
        long start = System.currentTimeMillis();
        boolean result = function.apply(arr);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.printf("%s : #%d : elapsed time = %d%n", result, id, elapsed);
    }

    private static int[] make(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (data[j] == data[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean unique2(int[] data) {
        int[] sorted = Arrays.copyOf(data, data.length);
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length - 1; i++) {
            if (sorted[i] == sorted[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
