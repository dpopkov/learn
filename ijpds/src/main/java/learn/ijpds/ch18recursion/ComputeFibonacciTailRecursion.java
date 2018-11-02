/* Q.18.10.2 */
package learn.ijpds.ch18recursion;

import java.util.Scanner;

public class ComputeFibonacciTailRecursion {
    private static int callCount;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an index of fibonacci number: ");
        int n = in.nextInt();
        System.out.println("The Fibonacci number at index " + n + " is " + fib(n));
        System.out.println("call count = " + callCount);
    }

    private static int fib(int n) {
        return fibTR(n, 0, 1);
    }

    private static int fibTR(int n, int prev, int curr) {
        callCount++;
        if (n == 0) {
            return prev;
        } else if (n == 1) {
            return curr;
        } else {
            return fibTR(n - 1, curr, prev + curr);
        }
    }
}
