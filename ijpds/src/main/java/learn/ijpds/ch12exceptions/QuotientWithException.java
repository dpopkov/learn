/* Listing 12.4 */
package learn.ijpds.ch12exceptions;

import java.util.Scanner;

public class QuotientWithException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        try {
            int result = quotient(n1, n2);
            System.out.printf("%d / %d is %d%n", n1, n2, result);
        } catch (ArithmeticException ex) {
            System.out.println("Exception: an integer cannot be divided by zero.");
        }
    }

    private static int quotient(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }
        return n1 / n2;
    }
}
