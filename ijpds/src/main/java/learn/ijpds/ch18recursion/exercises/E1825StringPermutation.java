/*
18.25
String permutation.
Write a recursive method to print all the permutations of a string
 */
package learn.ijpds.ch18recursion.exercises;

import java.util.Scanner;

public class E1825StringPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        permutation(s);
    }

    public static void permutation(String s) {
        permutation("", s);
    }

    public static void permutation(String s1, String s2) {
        if (s2.isEmpty()) {
            System.out.println(s1);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                char ch = s2.charAt(i);
                String newS1 = s1 + ch;
                String newS2 = s2.substring(0, i) + s2.substring(i + 1);
                permutation(newS1, newS2);
            }
        }
    }
}
