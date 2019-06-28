package learn.dsajg6e.ch05recursion.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Write a recursive method that will output all the subsets of a set of n elements
(without repeating any subsets).
 */
public class C0515Subsets {
    public static List<String> subsets(char[] elements) {
        List<String> result = new ArrayList<>();
        for (int size = 1; size < elements.length; size++) {
            populate(elements, "", size, result);
        }
        result.add(new String(elements));
        return result;
    }

    private static void populate(char[] universe, String sequence, int size, List<String> output) {
        for (int i = 0; i < universe.length; i++) {
            String newSequence = sequence + universe[i];
            if (size == 1) {
                output.add(newSequence);
            } else {
                char[] newUniverse = Arrays.copyOfRange(universe, i + 1, universe.length);
                populate(newUniverse, newSequence, size - 1, output);
            }
        }
    }
}
