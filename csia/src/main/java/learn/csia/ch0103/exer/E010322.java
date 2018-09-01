package learn.csia.ch0103.exer;

import learn.csia.utils.NumberArgs;

/**
 * 1.3.22 Write a code fragment that puts the binary representation of a positive
 * integer n into a String variable s
 */
public class E010322 {
    public static void main(String[] args) {
        int n = new NumberArgs(args, "Enter positive integer").nextInt();

        String result = new E010322().numberToString2(n);
        System.out.println(result);
    }

    public String numberToString1(int n) {
        int power = 1;
        while (power <= n / 2) {
            power *= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (power > 0) {
            if (n < power) {
                sb.append("0");
            } else {
                sb.append("1");
                n -= power;
            }
            power /= 2;
        }
        return sb.toString();
    }

    public String numberToString2(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            sb.insert(0, (i % 2));
        }
        return sb.toString();
    }
}
