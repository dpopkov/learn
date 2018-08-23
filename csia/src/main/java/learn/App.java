package learn;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int r = randomBetween(a, b);
        System.out.println(r);
    }

    public static int randomBetween(int from, int to) {
        int r = from + (int) (Math.random() * (to - from + 1));
        return r;
    }

    private static void test(boolean a, boolean b) {
        boolean r = (!(a && b) && (a || b)) || ((a && b) || !(a || b));
        System.out.printf("(%b, %b) -> %b%n", a, b, r);
    }


    private static void prn(double d) {
        System.out.println();
        System.out.println(d);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.round(d));
    }

}
