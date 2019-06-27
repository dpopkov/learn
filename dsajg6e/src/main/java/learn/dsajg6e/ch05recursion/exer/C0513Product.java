package learn.dsajg6e.ch05recursion.exer;

/*
Give a recursive algorithm to compute the product of two positive integers,
m and n, using only addition and subtraction.
 */
public class C0513Product {
    public static int product(int m, int n) {
        if (n == 1) {
            return m;
        }
        return product(0, m, n);
    }

    private static int product(int accumulator, int m, int n) {
        if (n == 0) {
            return accumulator;
        }
        return product(accumulator + m, m, n - 1);
    }
}
