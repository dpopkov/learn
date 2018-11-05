package learn.ijpds.ch18recursion.exercises;

import learn.ijpds.tools.ArrayTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E1811Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 1; i <= a.length; i++) {
            a[i - 1] = i;
        }
        List<int[]> p = permutations(a);
        p.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static List<int[]> permutations(int[] a) {
        ArrayList<int[]> list = new ArrayList<>();
        if (a.length == 1) {
            list.add(a);
        } else if (a.length > 1) {
            for (int i = 0; i < a.length; i++) {
                int first = a[i];
                int[] rest = ArrayTools.without(a, i);
                list.addAll(permutations(rest).stream()
                        .map(arr -> ArrayTools.insertAtStart(arr, first))
                        .collect(Collectors.toList()));
            }
        }
        return list;
    }
}
