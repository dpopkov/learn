package learn.dsajg6e.ch03fund;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 1, 4, 7, 6};

        for (int i = 0; i < 10; i++) {
            a = shuffle(a);
            System.out.printf("%s : %s%n", Arrays.toString(a), increasing(a));
            sort(a);
            System.out.printf("%s : %s%n", Arrays.toString(a), increasing(a));
            System.out.println();
        }
    }

    private static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int j = i;
            int current = data[i];
            while (j > 0 && data[j - 1] > current) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = current;
        }
    }

    private static boolean increasing(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] >= a[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] shuffle(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] a2 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            a2[i] = list.get(i);
        }
        return a2;
    }
}
