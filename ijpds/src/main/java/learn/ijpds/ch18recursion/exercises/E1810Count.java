package learn.ijpds.ch18recursion.exercises;

import java.util.Scanner;

public class E1810Count {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        System.out.print("Enter character: ");
        String ch = in.nextLine();
        int c = count(s, ch.charAt(0));
        System.out.println("count = " + c);
    }

    private static int count(String s, char character) {
        return count(s, character, 0);
    }

    private static int count(String s, char character, int from) {
        if (from >= s.length()) {
            return 0;
        }
        int rst = (s.charAt(from) == character) ? 1 : 0;
        return rst + count(s, character, from + 1);
    }
}
