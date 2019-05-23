package learn.javaio2e.ch21format;

import java.text.FieldPosition;
import java.text.NumberFormat;

/**
 * Using a FieldPosition object to figure out how many spaces to add to the front of the string.
 */
public class PrettierTable {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        FieldPosition fp = new FieldPosition(NumberFormat.INTEGER_FIELD);
        nf.setMaximumIntegerDigits(3);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        System.out.println("Degrees  Radians  Grads");
        for (double degrees = 0.0; degrees < 360.0; degrees++) {
            String radianString = nf.format(Math.PI * degrees / 180.0,
                    new StringBuffer(), fp).toString();
            radianString = getSpaces(3 - fp.getEndIndex()) + radianString;
            String gradString = nf.format(400 * degrees / 360,
                    new StringBuffer(), fp).toString();
            gradString = getSpaces(3 - fp.getEndIndex()) + gradString;
            String degreeString = nf.format(degrees, new StringBuffer(), fp).toString();
            degreeString = getSpaces(3 - fp.getEndIndex()) + degreeString;
            System.out.println(degreeString + " " + radianString + " " + gradString);
        }
    }

    private static String getSpaces(int n) {
        return " ".repeat(n);
    }
}
