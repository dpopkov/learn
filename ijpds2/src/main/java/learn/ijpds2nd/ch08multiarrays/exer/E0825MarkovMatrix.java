package learn.ijpds2nd.ch08multiarrays.exer;

/*
An n X n matrix is called a positive Markov matrix if each element is positive
and the sum of the elements in each column is 1.
 */
public class E0825MarkovMatrix {
    static boolean isMarkovMatrix(double[][] m) {
        int size = m.length;
        double sum0 = 0.0;
        for (double[] row : m) {
            sum0 += row[0];
        }
        for (int c = 1; c < size; c++) {
            double sum = 0.0;
            for (double[] row : m) {
                sum += row[c];
            }
            if (Math.abs(sum - sum0) > 1e-14) {
                return false;
            }
        }
        return true;
    }
}
