/* 20-1. An example to use the methods defined in the Collection interface. */
package learn.ijpds.ch20collections;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.println("A list of cities in collection:");
        System.out.println(collection1);
        System.out.println("Is Dallas in collection? " + collection1.contains("Dallas"));
        collection1.remove("Dallas");
        System.out.println(collection1.size() + " cities are in the collection now.");
        System.out.println(collection1);

        Collection<String> c2 = new ArrayList<>(4);
        c2.add("Seattle");
        c2.add("Portland");
        c2.add("Los Angeles");
        c2.add("Atlanta");
        System.out.println("\nA list of cities in collection2:");
        System.out.println(c2);

        Collection<String> c1 = (Collection<String>) collection1.clone();
        c1.addAll(c2);
        System.out.println("\nCities in collection1 or collection2: ");
        System.out.println(c1);

        c1 = (Collection<String>) collection1.clone();
        c1.retainAll(c2);
        System.out.println("\nCities in collection1 and collection2:");
        System.out.println(c1);

        c1 = (Collection<String>) collection1.clone();
        c1.removeAll(c2);
        System.out.println("\nCities in collection1, but not in collection2:");
        System.out.println(c1);
    }
}
