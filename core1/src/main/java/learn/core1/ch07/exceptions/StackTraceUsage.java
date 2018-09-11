package learn.core1.ch07.exceptions;

import learn.csia.utils.CliAppArgs;

/**
 * Displays a trace feature of a recursive method call.
 */
public class StackTraceUsage {
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter n");
        int n = in.nextInt();
        factorial(n);
    }
}
