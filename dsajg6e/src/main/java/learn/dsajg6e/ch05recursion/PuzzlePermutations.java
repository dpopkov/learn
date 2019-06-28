package learn.dsajg6e.ch05recursion;

import java.util.ArrayList;
import java.util.List;

import static learn.dsajg6e.tools.ArrayTools.deleteChar;

/**
 * Implementation of pseudo code of code fragment 5.11
 */
public class PuzzlePermutations {
    public static void solve(int k, String sequence, char[] universe, List<String> output) {
        for (int i = 0; i < universe.length; i++) {
            String newSequence = sequence + universe[i];
            if (k == 1) {
                output.add(newSequence);
            } else {
                solve(k - 1, newSequence, remove(universe, i), output);
            }
        }
    }

    static char[] remove(char[] universe, int index) {
        return deleteChar(universe, index);
    }



    public static void main(String[] args) {
        List<String> output = new ArrayList<>();
        char[] universe = {'a', 'b', 'c', 'd'};
        solve(3, "", universe, output);
        output.forEach(System.out::println);
    }
}
