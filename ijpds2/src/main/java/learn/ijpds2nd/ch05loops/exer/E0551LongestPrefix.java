package learn.ijpds2nd.ch05loops.exer;

import java.util.Scanner;

public class E0551LongestPrefix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 1st string: ");
        String w1 = in.nextLine();
        System.out.print("Enter 2nd string: ");
        String w2 = in.nextLine();
        int minLen = Math.min(w1.length(), w2.length());
        int i = 0;
        while (i < minLen && w1.charAt(i) == w2.charAt(i)) {
            i++;
        }
        if (i > 0) {
            System.out.printf("The common prefix is '%s'%n", w1.substring(0, i));
        } else {
            System.out.printf("'%s' and '%s' have no common prefix%n", w1, w2);
        }
    }
}
