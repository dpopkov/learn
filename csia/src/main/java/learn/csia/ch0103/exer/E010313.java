package learn.csia.ch0103.exer;

/**
 * Reverses a number.
 */
public class E010313 {
    public static void main(String[] args) {
        int n = 123456789;
        int m = 0;
        while (n != 0) {
            m = m * 10 + n % 10;
            n /= 10;
        }
        System.out.println(m);
    }
}
