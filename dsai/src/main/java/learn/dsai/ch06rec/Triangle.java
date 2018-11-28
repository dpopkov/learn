package learn.dsai.ch06rec;

import java.util.Scanner;

public class Triangle {
    private static final boolean LOGGING = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        int rst = triangle(n);
        System.out.println("result = " + rst);
    }

    private static int triangle(int n) {
        logInfo("Entering: n=" + n);
        if (n == 1) {
            logInfo("Returning 1");
            return 1;
        }
        int result = n + triangle(n - 1);
        logInfo("Returning " + result);
        return result;
    }

    private static void logInfo(String s) {
        if (LOGGING) {
            System.out.println(s);
        }
    }
}
