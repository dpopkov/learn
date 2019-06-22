package learn.dsajg6e.ch04analysis;

import learn.dsajg6e.tools.Input;

import java.util.function.Function;

/*
 size     #1   #2
 ----------------
 20000    278    1
 40000   1278    2
 80000   4478    2
160000  17789    3
 */
public class ExperimentsPrefixAverage {
    public static void main(String[] args) {
        int size = Input.nextInt("Enter size: ");
        double[] arr = make(size);
        test(1, arr, ExperimentsPrefixAverage::prefixAverage1);
        test(2, arr, ExperimentsPrefixAverage::prefixAverage2);
    }

    private static void test(int id, double[] arr, Function<double[], double[]> function) {
        long start = System.currentTimeMillis();
        function.apply(arr);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.printf("#%d : elapsed time = %d%n", id, elapsed);
    }

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j <= i; j++) {
                total += x[j];
            }
            a[i] = total / (i + 1);
        }
        return a;
    }

    private static double[] make(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += x[i];
            a[i] = total / (i + 1);
        }
        return a;
    }
}
