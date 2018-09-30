/* 20.6.5
Write a statement that sorts an array of Point2D objects on their y values and then
on their x values.
 */
package learn.ijpds.ch20collections.checkpoints;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;

public class Cp200605 {
    public static void main(String[] args) {
        Point2D[] points = {
                new Point(2, 3),
                new Point(2, 2),
                new Point(1, 4),
                new Point(1, 2)
        };
        System.out.println(Arrays.toString(points));
        Arrays.sort(points, Comparator.comparingDouble(Point2D::getX));
        System.out.println(Arrays.toString(points));
        Arrays.sort(points, Comparator
                .comparingDouble(Point2D::getY)
                .thenComparingDouble(Point2D::getX));
        System.out.println(Arrays.toString(points));
    }
}
