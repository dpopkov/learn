package learn.dsajg6e.ch02oop.exer;

public class P0234Polygons {
    private interface Polygon {
        double area();
        double perimeter();
    }

    private static abstract class AbstractPolygon implements Polygon {
        protected int numVertices;
        protected final double[] x;
        protected final double[] y;

        public AbstractPolygon(int numVertices) {
            x = new double[numVertices];
            y = new double[numVertices];
        }

        protected void addVertex(double x0, double y0) {
            x[numVertices] = x0;
            y[numVertices++] = y0;
        }

        protected double sideLength(int i0, int i1) {
            double dx = x[i0] - x[i1];
            double dy = y[i0] - y[i1];
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    private static class Triangle extends AbstractPolygon {
        public Triangle(double x0, double y0, double x1, double y1, double x2, double y2) {
            super(3);
            addVertex(x0, y0);
            addVertex(x1, y1);
            addVertex(x2, y2);
        }

        @Override
        public double area() {
            double a = x[0] * (y[1] - y[2]) + x[1] * (y[2] - y[0]) + x[2] * (y[0] - y[1]);
            return Math.abs(a / 2.0);
        }

        @Override
        public double perimeter() {
            double s0 = sideLength(0, 1);
            double s1 = sideLength(1, 2);
            double s2 = sideLength(0, 2);
            return s0 + s1 + s2;
        }
    }

    private static class Rectangle implements Polygon {
        private final double leftX;
        private final double topY;
        private final double width;
        private final double height;

        public Rectangle(double leftX, double topY, double width, double height) {
            this.leftX = leftX;
            this.topY = topY;
            this.width = width;
            this.height = height;
        }

        @SuppressWarnings("unused")
        public double getLeftX() {
            return leftX;
        }

        @SuppressWarnings("unused")
        public double getTopY() {
            return topY;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return 2 * (width + height);
        }
    }

    public static void main(String[] args) {
        System.out.println("Triangle:");
        Polygon triangle = new Triangle(0, 0, 0, 3, 4, 0);
        System.out.println("area = " + triangle.area());
        System.out.println("perimeter = " + triangle.perimeter());
        System.out.println("Rectangle:");
        Polygon rect = new Rectangle(0, 0, 3, 4);
        System.out.println("rect.area() = " + rect.area());
        System.out.println("rect.perimeter() = " + rect.perimeter());
    }
}
