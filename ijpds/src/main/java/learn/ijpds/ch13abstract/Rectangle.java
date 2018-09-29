package learn.ijpds.ch13abstract;

public class Rectangle extends GeometricObject {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rectangle(String color, boolean filled, double side1, double side2) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }
}
