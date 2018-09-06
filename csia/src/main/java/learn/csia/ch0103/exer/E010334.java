package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

/**
 * 1.3.34 Ramanujan’s taxi. Srinivasa Ramanujan was an Indian mathematician
 * who became famous for his intuition for numbers. When the English mathematician G. H. Hardy
 * came to visit him one day, Hardy remarked that the number of
 * his taxi was 1729, a rather dull number. To which Ramanujan replied, “No, Hardy!
 * No, Hardy! It is a very interesting number. It is the smallest number expressible as
 * the sum of two cubes in two different ways.” Verify this claim by writing a program
 * that takes an integer command-line argument n and prints all integers less than or
 * equal to n that can be expressed as the sum of two cubes in two different ways. In
 * other words, fnd distinct positive integers a, b, c, and d such that a3 + b3 = c3 + d3.
 * Use four nested for loops.
 */
public class E010334 {
    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args);
        int n = in.nextInt();
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    int lastLeft = 1;
                    if (c == a || c == b) continue;
                    for (int d = 1; d < n; d++) {
                        if (d == a || d == b) continue;
                        int left = a * a * a + b * b * b;
                        if (left != lastLeft && left == c * c * c + d * d * d) {
                            System.out.printf("%d ^ 3 + %d ^ 3 == %d ^ 3 + %d ^ 3 == %d%n", a, b, c, d, left);
                            lastLeft = left;
                        }
                    }
                }
            }
        }
    }
}
