package learn.leetcode.arrays;

import java.util.*;

public class R {
    public static void main(String[] args) {
        List<Integer> ns = new ArrayList<>();
        ns.add(3);
        ns.add(222);
        ns.add(1);
        System.out.println(ns);
        ns.sort(Comparator.naturalOrder());
        System.out.println(ns);
    }
}
