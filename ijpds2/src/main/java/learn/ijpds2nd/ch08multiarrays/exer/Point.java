package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Objects;

class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y) {
        this(x, y, 0);
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    static Point of(double x, double y) {
        return new Point(x, y);
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
