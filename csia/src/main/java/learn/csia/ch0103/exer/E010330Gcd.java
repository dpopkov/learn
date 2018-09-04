package learn.csia.ch0103.exer;

/**
 * 1.3.30 Write a program GreatestCommonDivisor that finds the greatest common
 * divisor (gcd) of two integers using Euclid’s algorithm, which is an iterative computation based on the
 * following observation: if x is greater than y, then if y divides x,
 * the gcd of x and y is y; otherwise, the gcd of x and y is the same as the gcd of x % y
 * and y.
 */
public class E010330Gcd {
    public int gcd(int x, int y) {
        if (x == y) {
            return x;
        } else if (x > y) {
            if (x % y == 0) {
                return y;
            } else {
                return gcd(y, x % y);
            }
        } else {
            return gcd(y, x);
        }
    }
}
