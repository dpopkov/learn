package learn.dsajg6e.ch05recursion;

import learn.dsajg6e.tools.Input;

/**
 * CF 5.1
 */
public class Factorial {
    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = Input.nextInt("n: ");
        int f = factorial(n);
        System.out.printf("factorial(%d) = %d%n", n, f);
    }
}
