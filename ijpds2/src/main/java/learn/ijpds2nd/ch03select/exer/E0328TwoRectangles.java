package learn.ijpds2nd.ch03select.exer;

import java.util.Scanner;

public class E0328TwoRectangles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter coordinates of center (x, y), width, and height of 1st rectangle: ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double w1 = in.nextDouble();
        double h1 = in.nextDouble();
        System.out.println("Enter coordinates of center (x, y), width, and height of 2nd rectangle: ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double w2 = in.nextDouble();
        double h2 = in.nextDouble();
        String result = overlappingRectangles(x1, y1, w1, h1, x2, y2, w2, h2);
        System.out.println(result);
    }

    static String overlappingRectangles(double x1, double y1, double w1, double h1, double x2, double y2, double w2, double h2) {
        double hw1 = w1 / 2;
        double hw2 = w2 / 2;
        double hh1 = h1 / 2;
        double hh2 = h2 / 2;
        double leftR1 = x1 - hw1;
        double leftR2 = x2 - hw2;
        double rightR1 = x1 + hw1;
        double rightR2 = x2 + hw2;
        double bottomR1 = y1 - hh1;
        double bottomR2 = y2 - hh2;
        double topR1 = y1 + hh1;
        double topR2 = y2 + hh2;
        if (rightR2 < leftR1 || bottomR2 > topR1 || leftR2 > rightR1 || topR2 < bottomR1) {
            return "r2 does not overlap r1";
        } else if (leftR1 <= leftR2
                && rightR2 <= rightR1
                && bottomR1 <= bottomR2
                && topR2 <= topR1) {
            return "r2 is inside r1";
        } else {
            return "r2 overlaps r1";
        }
    }
}
