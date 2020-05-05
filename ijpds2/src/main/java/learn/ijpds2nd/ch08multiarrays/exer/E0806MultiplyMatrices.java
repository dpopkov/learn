package learn.ijpds2nd.ch08multiarrays.exer;

public class E0806MultiplyMatrices {
    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int height = a.length;
        int width = b.length;
        int numAdd = a[0].length;
        double[][] result = new double[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double sum = 0;
                for (int k = 0; k < numAdd; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
