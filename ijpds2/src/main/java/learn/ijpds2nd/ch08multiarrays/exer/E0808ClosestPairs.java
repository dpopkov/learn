package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.ArrayList;
import java.util.List;

public class E0808ClosestPairs {

    public static void main(String[] args) {
        String s = "0 0 1 1 -1 -1 2 2 -2 -2 -3 -3 -4 -4 5 5";
        Point[] pa = parsePoints(s);
        List<Pair<Point>> r = closestPairs(pa);
        for (Pair<Point> p : r) {
            Point p1 = p.getP1();
            Point p2 = p.getP2();
            System.out.printf("The closest two points are %s and %s%n", p1, p2);
        }
    }

    public static List<Pair<Point>> closestPairs(Point[] points) {
        List<Pair<Point>> pairs = new ArrayList<>();
        double minDistance = points[0].distanceTo(points[1]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].distanceTo(points[j]);
                if (dist < minDistance) {
                    minDistance = dist;
                    pairs.clear();
                    Pair<Point> pair = new Pair<>(points[i], points[j]);
                    pairs.add(pair);
                } else if (dist == minDistance) {
                    Pair<Point> pair = new Pair<>(points[i], points[j]);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    private static Point[] parsePoints(String s) {
        String[] tokens = s.split(" ");
        Point[] points = new Point[tokens.length / 2];
        for (int i = 0; i < points.length; i++) {
            double x = Double.parseDouble(tokens[i * 2]);
            double y = Double.parseDouble(tokens[i * 2 + 1]);
            points[i] = Point.of(x, y);
        }
        return points;
    }
}
