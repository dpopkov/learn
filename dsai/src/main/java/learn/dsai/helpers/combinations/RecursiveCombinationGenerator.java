package learn.dsai.helpers.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RecursiveCombinationGenerator {
    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    private void helper(List<int[]> combinations, int[] data, int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n and r: ");
        int n = in.nextInt();
        int r = in.nextInt();
        RecursiveCombinationGenerator generator = new RecursiveCombinationGenerator();
        List<int[]> selection = generator.generate(n, r);
        selection.forEach(a -> System.out.println(Arrays.toString(a)));
    }
}
