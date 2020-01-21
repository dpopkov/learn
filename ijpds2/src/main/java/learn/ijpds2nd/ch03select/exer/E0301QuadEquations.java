package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0301QuadEquations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter values for a, b, and c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double d = discriminant(b, a, c);
        if (d < 0) {
            System.out.println("The equation has no real roots");
        } else if (d == 0.0) {
            double r = -b / (2 * a);
            System.out.println("One root: " + r);
        } else {
            double r1 = (-b + Math.pow(d, 0.5)) / (2 * a);
            double r2 = (-b - Math.pow(d, 0.5)) / (2 * a);
            System.out.println("First root : " + r1);
            System.out.println("Second root: " + r2);
        }
    }

    private static double discriminant(double b, double a, double c) {
        return b * b - 4 * a * c;
    }
}
