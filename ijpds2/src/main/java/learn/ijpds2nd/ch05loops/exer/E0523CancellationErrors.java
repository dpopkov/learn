package learn.ijpds2nd.ch05loops.exer;

@SuppressWarnings("SameParameterValue")
public class E0523CancellationErrors {
    public static void main(String[] args) {
        final int n = 50_000;
        double r1 = sumLeftToRight(n);
        double r2 = sumRightToLeft(n);
        System.out.println(r1);
        System.out.println(r2);
    }

    private static double sumRightToLeft(int n) {
        double sum = 0;
        for (int i = n; i >= 1; i--) {
            sum += 1.0 / i;
        }
        return sum;
    }

    private static double sumLeftToRight(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
}
