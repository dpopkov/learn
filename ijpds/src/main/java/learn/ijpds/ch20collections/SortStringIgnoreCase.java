package learn.ijpds.ch20collections;

import java.util.Arrays;
import java.util.List;

public class SortStringIgnoreCase {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Atlanta", "Savannah", "New York", "Dallas");
//        cities.sort((c1, c2) -> c1.compareToIgnoreCase(c2));
        cities.sort(String::compareToIgnoreCase);
        cities.forEach(s -> System.out.print(s + " "));
    }
}
