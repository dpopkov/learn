package learn.ijpds2nd.ch09obj;

/* Listing 9.8 */
public class Circle {
    private static int numberOfObjects = 0;

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        numberOfObjects++;
    }

    public Circle() {
        this(1.0);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = (radius >= 0) ? radius : 0;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + '}';
    }
}
