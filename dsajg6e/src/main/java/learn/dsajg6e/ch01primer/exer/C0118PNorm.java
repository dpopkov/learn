package learn.dsajg6e.ch01primer.exer;

/**
 * Calculating p-norm of a vector v in n-dimensional space.
 */
public class C0118PNorm {
    public static void main(String[] args) {
        int[] v = {3, 4};
        double pn = norm(v);
        System.out.println("p-norm = " + pn);
    }

    /** Calculates Euclidean norm. */
    private static double norm(int[] v) {
        return norm(v, 2);
    }

    @SuppressWarnings("SameParameterValue")
    private static double norm(int[] v, int p) {
        double sum = 0.0;
        for (int i : v) {
            sum += Math.pow(i, p);
        }
        double rst;
        if (p == 2) {
            rst = Math.sqrt(sum);
        } else if (p == 3) {
            rst = Math.cbrt(sum);
        } else {
            rst = Math.pow(sum, 1.0 / p);
        }
        return rst;
    }
}
