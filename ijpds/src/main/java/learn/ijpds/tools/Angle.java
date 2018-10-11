package learn.ijpds.tools;

/**
 * Calculates positive angle in degrees. Range from 0 to 360 degrees.
 */
public class Angle {
    /**
     * Gets angle of line.
     * @param x1 starting X
     * @param y1 starting Y
     * @param x2 ending X
     * @param y2 ending Y
     * @return angle of line in degrees
     */
    public static double get(double x1, double y1, double x2, double y2) {
        return get(x2 - x1, y2 - y1);
    }

    /**
     * Gets angle.
     * @param dx delta X
     * @param dy delta Y
     * @return angle in degrees
     */
    public static double get(double dx, double dy) {
        double radians = Math.atan(dy / dx);
        if (dx < 0) {
            radians += Math.PI;
        } else if (dy < 0) {
            radians = Math.PI * 2 + radians;
        }
        double degrees = Math.toDegrees(radians);
        return convertToPositiveRange(degrees);
    }

    /**
     * Angle between 2 lines with given coordinates.
     * @param x1 first line start X
     * @param y1 first line start Y
     * @param x2 first line end X
     * @param y2 first line end Y
     * @param x3 second line start X
     * @param y3 second line start Y
     * @param x4 second line end X
     * @param y4 second line end Y
     * @return angle between lines
     */
    public static double between(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double a1 = get(x1, y1, x2, y2);
        double a2 = get(x3, y3, x4, y4);
        double a = Math.abs(a2 - a1);
        if (a > 90.0) {
            a = 360.0 - a;
        }
        return a;
    }

    /**
     * Reverses angle to 180 degrees.
     * @param angle angle in degrees
     * @return reversed angle
     */
    public static double reverse(double angle) {
        angle += 180.0;
        return convertToPositiveRange(angle);
    }

    /**
     * Converts angle to range from 0 to 360 degrees.
     * @param angle angle in degrees
     * @return converted angle in range from 0 to 360 degrees
     */
    public static double convertToPositiveRange(double angle) {
        if (angle < 0.0) {
            angle = 360.0 + angle;
        }
        if (angle > 360.0) {
            angle = angle % 360.0;
        }
        return angle;
    }
}
