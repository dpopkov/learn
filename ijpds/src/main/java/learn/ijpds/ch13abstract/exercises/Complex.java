/* Exercise 13.17 */
package learn.ijpds.ch13abstract.exercises;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Complex implements Comparable<Complex>, Cloneable {
    public static final Complex ZERO = new Complex();

    private double real;
    private double imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add(Complex c) {
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    public Complex subtract(Complex c) {
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    public Complex multiply(Complex c) {
        return new Complex(real * c.real - imaginary * c.imaginary,
                imaginary * c.real + real* c.imaginary);
    }

    public Complex divide(Complex c) {
        double realPart = (real * c.real + imaginary * c.imaginary)
                / (c.real * c.real + c.imaginary * c.imaginary);
        double imaginaryPart = (imaginary * c.real - real * c.imaginary)
                / (c.real * c.real + c.imaginary * c.imaginary);
        return new Complex(realPart, imaginaryPart);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    @Override
    public String toString() {
        if (imaginary == 0) {
            return Double.toString(real);
        }
        return String.format("(%f + %fi)", real, imaginary);
    }

    @Override
    public int compareTo(Complex o) {
        return Double.compare(this.abs(), o.abs());
    }

    @Override
    protected Complex clone()  {
        try {
            return (Complex)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning", e);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double r1 = in.nextDouble();
        double i1 = in.nextDouble();
        Complex c1 = new Complex(r1, i1);
        System.out.print("Enter the second complex number: ");
        double r2 = in.nextDouble();
        double i2 = in.nextDouble();
        Complex c2 = new Complex(r2, i2);
        test(c1, c2, Complex::add, "+");
        test(c1, c2, Complex::subtract, "-");
        test(c1, c2, Complex::multiply, "*");
        test(c1, c2, Complex::divide, "/");
        test(c1, Complex::abs, "abs");
    }

    private static <T extends Complex> void test(T a, T b, BiFunction<T, T, T> bf, String op) {
        T result = bf.apply(a, b);
        System.out.printf("%s %s %s = %s%n", a, op, b, result);
    }

    private static <T extends Complex> void test(T a, Function<T, Double> f, String op) {
        Double result = f.apply(a);
        System.out.printf("%s%s = %f%n", op, a, result);
    }
}
