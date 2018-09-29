/* 20.6 */
package learn.ijpds.ch20collections;

import learn.ijpds.ch13abstract.Circle;
import learn.ijpds.ch13abstract.GeometricObject;
import learn.ijpds.ch13abstract.Rectangle;

import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5, 5);
        GeometricObject g2 = new Circle(5);
//        GeometricObject g = max(g1, g2, new GeometricObjectComparator());
//        GeometricObject g = max(g1, g2, (o1, o2) -> Double.compare(o1.getArea(), o2.getArea()));
        GeometricObject g = max(g1, g2, Comparator.comparingDouble(GeometricObject::getArea));
        System.out.println("The area of the larger object is " + g.getArea());
    }

    private static GeometricObject max(GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> comparator) {
        return comparator.compare(g1, g2) > 0 ? g1 : g2;
    }
}
