package learn.dsajg6e.ch12sortselect.exer;

import learn.dsajg6e.ch02oop.generics.Pair;
import learn.dsajg6e.ch12sortselect.MergeSortArray;

import java.util.Arrays;
import java.util.Comparator;

import static learn.dsajg6e.ch02oop.generics.Pair.*;

public class R1204CheckStableMergeSort {

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Pair<Integer, String>[] pa = (Pair<Integer, String>[]) new Pair<?, ?>[] {
                of(10, "101"),
                of(20, "201"),
                of(10, "102")
        };
        System.out.println(Arrays.toString(pa));
        MergeSortArray.mergeSort(pa, Comparator.comparing(Pair::getFirst));
        System.out.println(Arrays.toString(pa));
    }
}
