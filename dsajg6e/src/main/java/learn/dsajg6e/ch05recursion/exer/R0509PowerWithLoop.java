package learn.dsajg6e.ch05recursion.exer;

public class R0509PowerWithLoop {
    public static int pow(int x, int p) {
        System.out.printf("pow(%d, %d)...%n", x, p);
        if (p == 0) {
            return 1;
        }
        int r = x;
        int m = 1;
        while (m < p) {
            if (m * 2 <= p) {
                r = r * r;
                m = m * 2;
            } else {
                r *= x;
                m++;
            }
            System.out.printf("r, m = %d, %d%n", r, m);
        }
        return r;
    }
}
