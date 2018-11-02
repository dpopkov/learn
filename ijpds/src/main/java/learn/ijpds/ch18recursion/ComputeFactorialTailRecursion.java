/* 18.10 */
package learn.ijpds.ch18recursion;

import java.util.Scanner;

public class ComputeFactorialTailRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();

        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    /**
     * @return factorial for the specified number
     */
    public static long factorial(int n) {
        return factorial(n, 1);
    }

    /** Auxiliary tail-recursive method for factorial. */
    private static long factorial(int n, int result) {
        if (n == 0) {
            return result;
        }
        return factorial(n - 1, n * result);
    }
}
