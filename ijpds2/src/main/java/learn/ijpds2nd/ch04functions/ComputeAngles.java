package learn.ijpds2nd.ch04functions;

import java.util.Scanner;

/**
 * Listing 4.1
 * Prompts the user to enter the x, y coordinates of the three corner points
 * in a triangle then displays the three angles.
 */
public class ComputeAngles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter three points: ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();

        double a = distance(x2, y2, x3, y3);
        double b = distance(x1, y1, x3, y3);
        double c = distance(x1, y1, x2, y2);

        double angleA = angle(a, b, c);
        double angleB = angle(b, a, c);
        double angleC = angle(c, b, a);

        System.out.println("The three angles are "
                + Math.round(angleA * 100) / 100.0 + " "
                + Math.round(angleB * 100) / 100.0 + " "
                + Math.round(angleC * 100) / 100.0);
    }

    private static double angle(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
