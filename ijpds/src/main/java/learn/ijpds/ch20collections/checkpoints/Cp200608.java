/* 20.6.8
Write a statement that sorts a two-dimensional array of double[][] in increasing
order of their second column as the primary order and the first column as the secondary order.
 */
package learn.ijpds.ch20collections.checkpoints;

import java.util.Arrays;
import java.util.Comparator;

public class Cp200608 {
    @SuppressWarnings("ComparatorCombinators")
    public static void main(String[] args) {
        double[][] x = {{3, 1}, {2, -1}, {2, 0}, {1, -1}};
        System.out.println(Arrays.deepToString(x));
//        Arrays.sort(x, ((Comparator<double[]>) Comparator.comparingDouble(o -> o[1])).thenComparingDouble(value -> value[0]));
        Arrays.sort(x, ((Comparator<double[]>) (o1, o2) -> Double.compare(o1[1], o2[1]))
                .thenComparingDouble(value -> value[0]));
        System.out.println(Arrays.deepToString(x));
    }
}
