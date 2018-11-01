/* 18.2 */
package learn.ijpds.ch18recursion;

import java.util.Scanner;

public class ComputeFibonacci {
    private static int callCount;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int n = in.nextInt();
        System.out.println("The Fibonacci number at index " + n + " is " + fib(n));
        System.out.println("callCount = " + callCount);
    }

    private static int fib(int n) {
        callCount++;
        int rst;
        if (n == 0) {
            rst = 0;
        } else if (n == 1) {
            rst = 1;
        } else {
            rst = fib(n - 2) + fib(n - 1);
        }
        return rst;
    }
}
