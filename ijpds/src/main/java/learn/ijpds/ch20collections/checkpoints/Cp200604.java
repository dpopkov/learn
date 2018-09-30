/* 20.6.4
Create a comparator using a lambda expression and the Comparator.comparing
method, respectively, to compare Collection objects on their size.
 */
package learn.ijpds.ch20collections.checkpoints;

import java.util.*;

public class Cp200604 {
    public static void main(String[] args) {
        List<Collection<?>> collections = new ArrayList<>();
        collections.add(Arrays.asList(3, 4, 5));
        collections.add(Arrays.asList(1, 2));
        System.out.println("Initial:");
        collections.forEach(System.out::println);
//        collections.sort((c1, c2) -> c1.size() - c2.size());
        collections.sort(Comparator.comparingInt(Collection::size));
        System.out.println("Sorted:");
        collections.forEach(System.out::println);
    }
}
