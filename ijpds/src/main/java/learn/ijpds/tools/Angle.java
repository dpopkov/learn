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
