package learn.dsajg6e.ch12sortselect.exer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class R1207Union<E extends Comparable<E>> {
    public List<E> union(Iterator<E> i1, Iterator<E> i2) {
        ArrayList<E> list = new ArrayList<>();
        E e1 = null;
        E e2 = null;
        while ((i1.hasNext() || e1 != null) && (i2.hasNext() || e2 != null)) {
            if (e1 == null) {
                e1 = i1.next();
            }
            if (e2 == null) {
                e2 = i2.next();
            }
            int cmp = e1.compareTo(e2);
            if (cmp < 0) {
                list.add(e1);
                e1 = null;
            } else if (cmp > 0) {
                list.add(e2);
                e2 = null;
            } else {
                list.add(e1);
                e1 = null;
                e2 = null;
            }
        }
        if (e1 != null) {
            list.add(e1);
        } else if (e2 != null) {
            list.add(e2);
        }
        while (i1.hasNext()) {
            list.add(i1.next());
        }
        while (i2.hasNext()) {
            list.add(i2.next());
        }
        return list;
    }
}
