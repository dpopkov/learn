package learn.csia.ch0102.exer;

import java.io.IOException;
import java.util.Scanner;

/**
 1.2.15 Write a program that takes three positive integers as command-line
 arguments and prints false if any one of them is greater than or equal to the sum
 of the other two and true otherwise. (Note : This computation tests whether the
 three numbers could be the lengths of the sides of some triangle.)
 */
public class E010215Triangle {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        boolean r = canMakeTriangle(a, b, c);
        System.out.println(r);
    }

    public static boolean canMakeTriangle(int a, int b, int c) {
        boolean tooLong =  a > (b + c);
        tooLong = tooLong || b > (a + c);
        tooLong = tooLong || c > (a + b);
        return !tooLong;
    }
}
