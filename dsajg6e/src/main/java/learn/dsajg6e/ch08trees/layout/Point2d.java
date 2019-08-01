package learn.dsajg6e.ch08trees.layout;

/** Simple 2d point. */
public class Point2d implements CoordinatesXY {
    private int x;
    private int y;

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + '}';
    }

    public static Point2d of(int x, int y) {
        return new Point2d(x, y);
    }
}
