package learn.dsai.ch06rec.projects;

public class P0603Power {
    private int callCount;

    public int getCallCount() {
        return callCount;
    }

    public int pow(int x, int y) {
        callCount++;
        if (y == 1) {
            return x;
        } else if (y % 2 == 0) {
            int x2 = x * x;
            if (y == 2) {
                return x2;
            } else {
                return pow(x2, y / 2);
            }
        }
        return x * pow(x, y - 1);
    }
}
