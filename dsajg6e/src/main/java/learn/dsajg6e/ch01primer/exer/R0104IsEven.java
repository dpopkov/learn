package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.Input;

public class R0104IsEven {
    public static void main(String[] args) {
        long n = Input.nextLong("n: ");
        boolean rst = isEven(n);
        System.out.println(rst ? "n is even" : "n is odd");
    }

    private static boolean isEven(long n) {
        return (n & 1) == 0;
    }
}
