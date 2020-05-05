package learn.ijpds2nd.ch08multiarrays.exer;

public class E0805AddMatrices {
    public static double[][] addMatrices(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a[0].length];
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                result[r][c] = a[r][c] + b[r][c];
            }
        }
        return result;
    }
}
