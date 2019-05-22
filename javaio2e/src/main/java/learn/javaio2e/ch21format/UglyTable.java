package learn.javaio2e.ch21format;

/**
 * Prints a three-column table of the angles between 0 and 360 degrees in degrees,
 * radians and grads without any formatting
 */
public class UglyTable {
    public static void main(String[] args) {
        System.out.println("Degrees \tRadians \tGrads");
        for (double degrees = 0.0; degrees < 360.0; degrees++) {
            double radians = Math.PI * degrees / 180.0;
            double grads = 400 * degrees / 360;
            System.out.println(degrees + "\t" + radians + "\t" + grads);
        }
    }
}
