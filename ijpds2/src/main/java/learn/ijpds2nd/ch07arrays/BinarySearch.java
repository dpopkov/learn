package learn.ijpds2nd.ch07arrays;

import java.util.Arrays;
import java.util.Scanner;

/* Listing 7.7 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {3, 5, 7, 11, 17};
        System.out.println("Array: " + Arrays.toString(a));
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the key: ");
        int key = in.nextInt();
        int idx = binarySearch(a, key);
        System.out.println("Found at index " + idx);
    }

    private static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -low - 1;
    }
}
