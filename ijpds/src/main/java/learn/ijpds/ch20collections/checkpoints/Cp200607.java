/* 20.6.7
Write a statement that sorts a two-dimensional array of double[][] in increasing order
of their second column.
 */
package learn.ijpds.ch20collections.checkpoints;

import java.util.Arrays;
import java.util.Comparator;

public class Cp200607 {
    public static void main(String[] args) {
        double[][] x = {{3, 1}, {2, -1}, {2, 0}};
        System.out.println(Arrays.deepToString(x));
//        Arrays.sort(x, (o1, o2) -> Double.compare(o1[1], o2[1]));
        Arrays.sort(x, Comparator.comparingDouble(v -> v[1]));
        System.out.println(Arrays.deepToString(x));
    }
}
