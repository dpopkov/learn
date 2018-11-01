/* 18.6 */
package learn.ijpds.ch18recursion;

import java.util.Arrays;
import java.util.Scanner;

public class RecursivelyBinarySearch {
    public static int recursiveBinarySearch(int[] list, int key) {
        return recursiveBinarySearch(list, key, 0, list.length - 1);
    }

    private static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high) {
            return -low - 1;
        }
        int mid = low + (high - low) / 2;
        if (list[mid] == key) {
            return mid;
        } else if (list[mid] < key) {
            return recursiveBinarySearch(list, key, mid + 1, high);
        } else {
            return recursiveBinarySearch(list, key, low, high - 1);
        }
    }

    private static int nonRecursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] < key) {
                low++;
            } else {
                high--;
            }
        }
        return -low - 1;
    }

    public static void main(String[] args) {
        int[] a = {0, 10, 20, 30, 40, 50, 60, 70};
        System.out.println(Arrays.toString(a));
        Scanner in = new Scanner(System.in);
        System.out.print("Enter key: ");
        int n = in.nextInt();
        int r = recursiveBinarySearch(a, n);
        System.out.println("r = " + r);
        int r2 = nonRecursiveBinarySearch(a, n);
        System.out.println("r2 = " + r2);
    }
}
