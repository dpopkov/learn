package learn.csia.ch0102.exer;

import java.util.Scanner;

/**
 1.2.34 Three-sort. Write a program that takes three integer command-line arguments and prints them in ascending order.
 Use Math.min() and Math.max().
 */
public class E010234ThreeSort {
    public static void main(String[] args) {
        int a, b, c;
        if (args.length >= 3) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            c = Integer.parseInt(args[2]);
        } else {
            Scanner in = new Scanner(System.in);
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
        }
        // Implementing this requirement to use Math.min() and Math.max().
        // I would prefer not to do this, but use an array and moving its elements.
        int n0 = Math.min(Math.min(a, b), c);
        int n2 = Math.max(Math.max(a, b), c);
        int n1 = (n0 < a && a < n2) ? a : ((n0 < b && b < n2) ? b : c);
        System.out.println(n0);
        System.out.println(n1);
        System.out.println(n2);
    }
}
