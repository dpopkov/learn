package learn.ijpds.ch11Inheritance;

import learn.csia.utils.CliAppArgs;
import learn.ijpds.ch12exceptions.exercises.IllegalTriangleException;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        setSides(1, 1, 1);
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        setSides(side1, side2, side3);
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled)
            throws IllegalTriangleException {
        super(color, filled);
        setSides(side1, side2, side3);
    }

    private void setSides(double side1, double side2, double side3) {
        if (side1 > (side2 + side3)
                || side2 > (side1 + side3)
                || side3 > (side1 + side2)) {
            throw new IllegalTriangleException(String.format(
                    "Sides do not form a proper triangle: %f, %f, %f.",
                    side1, side2, side3));
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter side1", "Enter side2", "Enter side3");
        int s1 = in.nextInt();
        int s2 = in.nextInt();
        int s3 = in.nextInt();
        Triangle triangle = new Triangle(s1, s2, s3);
        System.out.println(triangle);

    }
}
