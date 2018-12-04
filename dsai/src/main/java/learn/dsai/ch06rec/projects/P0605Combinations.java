package learn.dsai.ch06rec.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P0605Combinations {
    public static void showTeams(int groupSize, int teamSize) {
        char[] group = makeGroup(groupSize);
        List<String> list = combinations(group, 0, teamSize);
        list.forEach(System.out::println);
    }

    public static List<String> combinations(char[] group, int start, int size) {
        List<String> list = new ArrayList<>();
        if (group.length < size) {
            return list;
        }
        if (size == 1) {
            for (int i = start; i < group.length; i++) {
                list.add(Character.toString(group[i]));
            }
        } else if (group.length - start == size) {
            list.add(String.valueOf(group, start, size));
        } else {
            char first = group[start];
            List<String> withFirst = combinations(group, start + 1, size - 1)
                    .stream().map(s -> first + s).collect(Collectors.toList());
            List<String> withoutFirst = combinations(group, start + 1, size);
            list.addAll(withFirst);
            list.addAll(withoutFirst);
        }
        return list;
    }

    private static char[] makeGroup(int size) {
        char[] group = new char[size];
        for (int i = 0; i < group.length; i++) {
            group[i] = (char) ('A' + i);
        }
        return group;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter group size: ");
        int group = in.nextInt();
        System.out.print("Enter team size: ");
        int team = in.nextInt();
        showTeams(group, team);
    }
}
