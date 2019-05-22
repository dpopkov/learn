package learn.javaio2e.ch21format;

import java.text.NumberFormat;

/**
 * The simplest use of NumberFormat.
 */
public class FormatTest {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance();
        for (double x = Math.PI; x < 100_000; x *= 10) {
            String formattedNumber = nf.format(x);
            System.out.println(formattedNumber + "\t" + x);
        }
    }
}
