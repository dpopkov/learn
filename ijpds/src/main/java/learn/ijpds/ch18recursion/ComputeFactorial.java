/* 18.1 */
package learn.ijpds.ch18recursion;

import java.util.Scanner;

public class ComputeFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();

        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
