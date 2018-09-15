/* Listing 12.1 */
package learn.ijpds.ch12exceptions;

import java.util.Scanner;

public class Quotient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        System.out.printf("%d / %d is %d%n", n1, n2, (n1 / n2));
    }
}
