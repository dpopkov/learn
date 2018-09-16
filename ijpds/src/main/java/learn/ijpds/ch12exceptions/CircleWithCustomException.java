package learn.ijpds.ch12exceptions;

@SuppressWarnings("unused")
public class CircleWithCustomException {
    private double radius;
    private static int numberOfObjects = 0;

    public CircleWithCustomException(double newRadius) throws InvalidRadiusException {
        setRadius(newRadius);
        numberOfObjects++;
    }

    public void setRadius(double radius) throws InvalidRadiusException {
        if (radius >= 0) {
            this.radius = radius;
        } else {
            throw new InvalidRadiusException(radius);
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
