package learn.ijpds2nd.ch05loops.exer;

public class E0526ComputeE {
    public static void main(String[] args) {
        final int n = 20;
        double e = 1.0;
        double t = 1.0;
        for (int i = 1; i <= n; i++) {
            t = t / i;
            e += t;
            if (i % 5 == 0) {
                System.out.printf("i = %6d, e = %.14f%n", i, e);
            }
        }
        System.out.printf("%10s, e = %.14f%n", "Math.E", Math.E);
    }
}
