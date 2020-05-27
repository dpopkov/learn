package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

/*
Write a program that prompts the user to enter four integers
and then displays all possible ways of arranging the four integers.
 */
public class E0728Permutations {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        int[] a = in.requestIntArray("Enter 4 integers: ");
        printPermutations(a);
    }

    public static void printPermutations(int[] a) {
        printAllRecursive(a.length, a, " ");
    }

    private static void printAllRecursive(int n, int[] elements, String delimiter) {
        if (n == 1) {
            printArray(elements, delimiter);
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if (n % 2 == 0) {
                    swap(i, n - 1, elements);
                } else {
                    swap(0, n - 1, elements);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }

    private static void printArray(int[] elements, String delimiter) {
        for (int i = 0; i < elements.length; i++) {
            if (i > 0) {
                System.out.print(delimiter);
            }
            System.out.print(elements[i]);
        }
        System.out.println();
    }

    private static void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
