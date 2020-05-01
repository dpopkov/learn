package learn.ijpds2nd.ch08multiarrays;

import java.util.Scanner;

/* Listing 8.3 */
public class FindNearestPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoints = in.nextInt();
        double[][] points = new double[numberOfPoints][2];
        System.out.print("Enter " + numberOfPoints + " points: ");
        for (int i = 0; i < numberOfPoints; i++) {
            points[i][0] = in.nextDouble();
            points[i][1] = in.nextDouble();
        }
        int p1 = 0;
        int p2 = 1;
        double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (shortestDistance > distance) {
                    shortestDistance = distance;
                    p1 = i;
                    p2 = j;
                }
            }
        }
        System.out.println("The closest two points are ("
                + points[p1][0] + ", " + points[p1][1] + ", " + points[p2][0] + ", " + points[p2][1] + ")");
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double sum = dx * dx + dy * dy;
        return Math.sqrt(sum);
    }
}
