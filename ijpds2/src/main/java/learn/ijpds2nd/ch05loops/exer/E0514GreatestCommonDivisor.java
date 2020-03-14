package learn.ijpds2nd.ch05loops.exer;

import java.util.Scanner;

public class E0514GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 2 integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int r = gcd(n1, n2);
        System.out.println("gcd = " + r);
    }

    private static int gcd(int a, int b) {
        int d = Math.min(a, b);
        while (a % d != 0 || b % d != 0) {
            d--;
        }
        return d;
    }
}
