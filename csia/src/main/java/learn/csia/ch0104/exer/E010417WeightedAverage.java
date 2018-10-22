/*
1.4.17
Weighted average of the rows.
 */
package learn.csia.ch0104.exer;

import learn.csia.utils.ArrayUtils;

import java.io.FileNotFoundException;

public class E010417WeightedAverage {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "io/data/array.txt";
        int[][] a = ArrayUtils.readTwoDimensional(path);
        System.out.println("Initial array:");
        ArrayUtils.printTwoDimensional(a);
        double[] weights = {0.25, 0.25, 0.50};
        double[] averages = ArrayUtils.averageOfRows(a, weights);
        ArrayUtils.printVertical(averages, 1);
    }
}
