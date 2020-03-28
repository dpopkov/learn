package learn.ijpds2nd.ch05loops.exer;

public class E0525ComputePi {
    public static void main(String[] args) {
        double sum = 0;
        int t = 1;
        for (int i = 1; i <= 110_000; i++) {
            sum += t / (2.0 * i - 1.0);
            t *= -1;
            if (i % 10_000 == 0) {
                double pi = 4 * sum;
                System.out.printf("i = %6d , pi = %.14f%n", i, pi);
            }
        }
        System.out.printf("%10s , pi = %.14f%n", "Math.PI", Math.PI);
    }
}
