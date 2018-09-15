/* Listing 12.2 */
package learn.ijpds.ch12exceptions;

import java.util.Scanner;

public class QuotientWithIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        if (n2 != 0) {
            System.out.printf("%d / %d is %d%n", n1, n2, (n1 / n2));
        } else {
            System.out.println("Divisor cannot be zero.");
        }
    }
}
