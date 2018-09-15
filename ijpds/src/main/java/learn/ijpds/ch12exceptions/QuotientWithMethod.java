/* Listing 12.3 */
package learn.ijpds.ch12exceptions;

import java.util.Scanner;

public class QuotientWithMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int result = quotient(n1, n2);
        System.out.printf("%d / %d is %d%n", n1, n2, result);
    }

    private static int quotient(int n1, int n2) {
        if (n2 == 0) {
            System.out.println("Divisor cannot be zero.");
            System.exit(1);
        }
        return n1 / n2;
    }
}
