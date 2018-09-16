package learn.ijpds.ch12exceptions;

public class InvalidRadiusException extends Exception {
    private final double radius;

    public InvalidRadiusException(double radius) {
        super("Invalid radius " + radius);
        this.radius = radius;
    }

    @SuppressWarnings("unused")
    public double getRadius() {
        return radius;
    }
}
