package learn.dsai.helpers.combinations;

import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    /**
     * @param arr   input
     * @param data  temporary array to store current combination
     * @param start staring index in arr
     * @param end   ending index in arr
     * @param dataIdx current index in data
     */
    static void combinationUtil(int[] arr, int[] data, int start,
                                int end, int dataIdx) {
        // If current combination is ready to be printed, print it
        if (dataIdx == data.length) {
            System.out.println(Arrays.toString(data));
            return;
        }
        // replace index with all possible elements. The condition
        // "end - arrIdx + 1 >= data.length - dataIdx" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int arrIdx = start;
             arrIdx <= end && end - arrIdx + 1 >= data.length - dataIdx;
             arrIdx++) {
            data[dataIdx] = arr[arrIdx];
            combinationUtil(arr, data, arrIdx + 1, end, dataIdx + 1);
        }
    }

    /**
     * The main function that prints all combinations of size r in arr.
     */
    static void printCombination(int[] arr, int r) {
        // A temporary array to store all combination one by one
        int[] data = new int[r];
        // Print all combinations
        combinationUtil(arr, data, 0, arr.length - 1, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter r: ");
        int r = in.nextInt();
        int[] arr = {1, 2, 3, 4};
        printCombination(arr, r);
    }
}
