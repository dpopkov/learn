package learn.dsajg6e.ch12sortselect.exer;

import learn.dsajg6e.ch02oop.generics.Pair;
import learn.dsajg6e.ch06stacks.LinkedQueue;
import learn.dsajg6e.ch06stacks.Queue;
import learn.dsajg6e.ch12sortselect.MergeSortQueue;

import java.util.Comparator;

public class R1205CheckStableMergeSort {
    public static void main(String[] args) {
        Queue<Pair<Integer, String>> queue = LinkedQueue.from(
                Pair.of(10, "101"),
                Pair.of(10, "102"),
                Pair.of(20, "200"),
                Pair.of(10, "103"),
                Pair.of(10, "104")
        );
        System.out.println(queue);
        MergeSortQueue.mergeSort(queue, Comparator.comparing(Pair::getFirst));
        System.out.println(queue);
    }
}
