package learn.ijpds2nd.ch06methods;

import java.util.Scanner;

/* Listing 6.6 */
public class GreatestCommonDivisorMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 1st integer: ");
        int n1 = in.nextInt();
        System.out.print("Enter 2nd integer: ");
        int n2 = in.nextInt();
        System.out.println("The greatest common divisor for " + n1 + " and " + n2 + " is " + gcd(n1, n2));
    }

    private static int gcd(int n1, int n2) {
        int gcd = 1;
        int k = 2;
        while (k <= n1 && k <= n2) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
            k++;
        }
        return gcd;
    }
}
