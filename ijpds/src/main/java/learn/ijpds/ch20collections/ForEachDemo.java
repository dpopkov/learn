/* 20.3. */
package learn.ijpds.ch20collections;

import java.util.ArrayList;
import java.util.Collection;

public class ForEachDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");
        collection.forEach(city -> System.out.print(city.toUpperCase() + " "));
        System.out.println();
    }
}
