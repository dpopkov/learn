package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Objects;

public class E0807NearestPoints {
    static class Point {
        private final double x;
        private final double y;
        private final double z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        static Point of(double x, double y, double z) {
            return new Point(x, y, z);
        }

        public double distanceTo(Point p2) {
            double dx = p2.x - x;
            double dy = p2.y - y;
            double dz = p2.z - z;
            double sum = dx * dx + dy * dy + dz * dz;
            return Math.sqrt(sum);
        }

        @Override
        public String toString() {
            return "Point{x=" + x + ", y=" + y + ", z=" + z + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0 &&
                    Double.compare(point.z, z) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    static class Pair {
        private final Point p1;
        private final Point p2;

        public Pair(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public String toString() {
            return "Pair{p1=" + p1 + ", p2=" + p2 + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return p1.equals(pair.p1) && p2.equals(pair.p2)
                    || p2.equals(pair.p1) && p1.equals(pair.p2);
        }

        @Override
        public int hashCode() {
            return p1.hashCode() + p2.hashCode();
        }
    }

    static Pair findNearestPoints(Point[] points) {
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
        return new Pair(points[p1], points[p2]);
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
