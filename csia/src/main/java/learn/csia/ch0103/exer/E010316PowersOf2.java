package learn.csia.ch0103.exer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.3.16 Write a program that takes an integer command-line argument n and
 * prints all the positive powers of 2 less than or equal to n. Make sure
 * that your program works properly for all values of n.
 */
public class E010316PowersOf2 {
    public List<Integer> getPowers(int n) {
        List<Integer> powers = new ArrayList<>();
        int x = 1;
        while (x <= n) {
            powers.add(x);
            x *= 2;
        }
        return powers;
    }
}
