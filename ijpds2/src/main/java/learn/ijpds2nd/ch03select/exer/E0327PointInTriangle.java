package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0327PointInTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x and y coordinates of a point: ");
        double x = in.nextDouble();
        double y = in.nextDouble();
         /*
         Equation of triangle hypo:
         y = -0.5x + 100
         y = -0.5x + c
         c = y + 0.5x
         */
        double c = y + 0.5 * x;
        boolean inTriangle = x > 0 && y > 0 & c <= 100;
        System.out.println("Point is " + (inTriangle ? "in triangle" : "not in triangle"));
    }
}
