package learn.ijpds.ch20collections;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringByLength {
    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};
//        Arrays.sort(cities, new StringComparator());
//        Arrays.sort(cities, (o1, o2) -> o1.length() - o2.length());
//        Arrays.sort(cities, Comparator.comparingInt(v -> v.length()));
        Arrays.sort(cities, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(cities));
    }

    @SuppressWarnings("unused")
    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }
}
