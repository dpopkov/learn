package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0329TwoCircles {
    enum Placing { INSIDE, OVERLAP, DO_NOT_OVERLAP}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter circle1's center x, y coordinates, and radius: ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double r1 = in.nextDouble();
        System.out.print("Enter circle2's center x, y coordinates, and radius: ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double r2 = in.nextDouble();
        Placing result = checkCircles(x1, y1, r1, x2, y2, r2);
        System.out.printf("circle2 %s circle1%n", result.toString());
    }

    static Placing checkCircles(double x1, double y1, double r1, double x2, double y2, double r2) {
        double d = distance(x1, y1, x2, y2);
        if (d > r1 + r2) {
            return Placing.DO_NOT_OVERLAP;
        } else if (d + r2 < r1) {
            return Placing.INSIDE;
        }
        return Placing.OVERLAP;
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
