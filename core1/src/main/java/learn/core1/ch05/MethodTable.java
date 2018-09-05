package learn.core1.ch05;

import java.lang.reflect.Method;

/**
 * Shows how to invoke methods through reflection.
 */
public class MethodTable {
    public static void main(String[] args) throws Exception {
        Method square = MethodTable.class.getMethod("square", double.class);
        printTable(1.0, 10.0, 10, square);
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        printTable(2, 9, 8, sqrt);
    }

    /**
     * Prints a table with x- and y-values for a method.
     * @param from the lower bound for the x-values
     * @param to the upper bould for the x-values
     * @param n number of rows in the table
     * @param method a method with a double parameter and double return value
     */
    private static void printTable(double from, double to, int n, Method method) {
        System.out.println(method);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (Double) method.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static double square(double x) {
        return x * x;
    }
}
