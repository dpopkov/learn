package learn.dsai.helpers.combinations;

import java.util.Scanner;

public class Combination {
    /**
     * @param arr   input
     * @param data  temporary array to store current combination
     * @param start staring index in arr
     * @param end   ending index in arr
     * @param index current index in data
     * @param r     size of a combination to be printed
     */
    static void combinationUtil(int[] arr, int[] data, int start,
                                int end, int index, int r) {
        // If current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println();
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    /**
     * The main function that prints all combinations of size r in arr of size n.
     */
    static void printCombination(int[] arr, int n, int r) {
        // A temporary array to store all combination one by one
        int[] data = new int[r];
        // Print all combinations
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter r: ");
        int r = in.nextInt();
        int[] arr = {1, 2, 3, 4};
        printCombination(arr, arr.length, r);
    }
}
