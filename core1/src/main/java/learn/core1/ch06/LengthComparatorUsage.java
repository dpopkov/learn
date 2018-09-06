package learn.core1.ch06;

import java.util.Arrays;

public class LengthComparatorUsage {
    public static void main(String[] args) {
        String[] friends = {"Peter", "Tim", "Bo", "Paul", "Mary"};
        System.out.println(Arrays.toString(friends));
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));
    }
}
