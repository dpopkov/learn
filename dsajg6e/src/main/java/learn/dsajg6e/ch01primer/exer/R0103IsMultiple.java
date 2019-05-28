package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.Input;

public class R0103IsMultiple {
    public static void main(String[] args) {
        long n = Input.nextLong("n: ");
        long m = Input.nextLong("m: ");
        boolean rst = isMultiple(n, m);
        System.out.println(rst ? "n is multiple of m" : "n is not multiple of m");
    }

    private static boolean isMultiple(long n, long m) {
        return n % m == 0;
    }
}
