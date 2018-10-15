package learn.csia.ch0104.exer;

public class E010403EuclideanDistance {
    public static void main(String[] args) {
        double[] a = {1.0, 2.0};
        double[] b = {3.0, 4.0};
        double r = euclideanDistance(a, b);
        System.out.println(r);
    }

    public static double euclideanDistance(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays must have equal lengths");
        }
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(Math.abs(a[i] - b[i]), 2);
        }
        return Math.sqrt(sum);
    }
}
