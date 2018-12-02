package learn.dsai.ch06rec.projects;

public class P0601Multiply {
    public int multiply(int x, int y) {
        if (y == 1) {
            return x;
        }
        return x + multiply(x, y - 1);
    }
}
