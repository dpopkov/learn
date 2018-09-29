/* 20.2. An example that uses the iterator to traverse all the elements in an array list */
package learn.ijpds.ch20collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");
        Iterator<String> iterator = collection1.iterator();
        //noinspection WhileLoopReplaceableByForEach
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();
    }
}
