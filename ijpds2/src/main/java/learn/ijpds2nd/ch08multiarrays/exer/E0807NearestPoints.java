package learn.ijpds2nd.ch08multiarrays.exer;

public class E0807NearestPoints {

    static Pair<Point> findNearestPoints(Point[] points) {
        int p1 = 0;
        int p2 = 1;
        double minDistance = points[p1].distanceTo(points[p2]);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].distanceTo(points[j]);
                if (minDistance > dist) {
                    p1 = i;
                    p2 = j;
                    minDistance = dist;
                }
            }
        }
        return new Pair<>(points[p1], points[p2]);
    }

    public static void main(String[] args) {
        Point p1 = Point.of(3.5, 2, -1);
        Point p2 = Point.of(3, 1.5, 3);
        System.out.println(p1.distanceTo(p2));

        Point p3 = Point.of(-1, 0, 3);
        Point p4 = Point.of(-1, -1, -1);
        System.out.println(p3.distanceTo(p4));

        Point p5 = Point.of(4, 1, 1);
        Point p6 = Point.of(3.5, 2, -1);
        System.out.println(p5.distanceTo(p6));
    }
}
