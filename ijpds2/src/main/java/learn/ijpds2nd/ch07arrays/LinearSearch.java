package learn.ijpds2nd.ch07arrays;

import java.util.Arrays;
import java.util.Scanner;

/* Listing 7.6 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] a = {3, 5, 7, 11, 17};
        System.out.println("Array: " + Arrays.toString(a));
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the key: ");
        int key = in.nextInt();
        int idx = linearSearch(a, key);
        System.out.println("Found at index " + idx);
    }

    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
