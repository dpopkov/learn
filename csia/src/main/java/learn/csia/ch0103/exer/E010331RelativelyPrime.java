package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

/**
 * 1.3.31 Write a program that takes an integer command-line argument n
 * and prints an n-by-n table such that there is an * in row i and column j
 * if the gcd of i and j is 1 (i and j are relatively prime) and a space
 * otherwise.
 */
public class E010331RelativelyPrime {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter size of table");
        int n = in.nextInt();
        E010330Gcd calculator = new E010330Gcd();
        System.out.print("   ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%2d", i);
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.printf("%3d", i);
            for (int j = 1; j <= n; j++) {
                System.out.print(calculator.gcd(i, j) == 1 ? " *" : "  ");
            }
            System.out.println();
        }
    }
}
