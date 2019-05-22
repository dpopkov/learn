package learn.javaio2e.ch21format;

import java.text.NumberFormat;

/**
 * Prints table with each number formatted to at least three integer digits
 * and exactly two fraction digits.
 */
public class PrettyTable {
    public static void main(String[] args) {
        System.out.println("Degrees Radians Grads");
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(3);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        for (double degrees = 0.0; degrees < 360.0; degrees++) {
            String radians = nf.format(Math.PI * degrees / 180.0);
            String grads = nf.format(400 * degrees / 360);
            String degStr = nf.format(degrees);
            System.out.println(degStr + " " + radians + " " + grads);
        }
    }
}
