/* 20.5 */
package learn.ijpds.ch20collections;

import learn.ijpds.ch13abstract.GeometricObject;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("unused")
public class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {
    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
