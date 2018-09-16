/* Listing 12.7 */
package learn.ijpds.ch12exceptions;

@SuppressWarnings("ALL")
public class CircleWithException {
    private double radius;
    private static int numberOfObjects = 0;

    public CircleWithException(double newRadius) {
        setRadius(newRadius);
        numberOfObjects++;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius >= 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
    }

    public double getRadius() {
        return radius;
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double findArea() {
        return radius * radius * Math.PI;
    }
}
