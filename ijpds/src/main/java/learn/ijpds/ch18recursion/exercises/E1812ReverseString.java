package learn.ijpds.ch18recursion.exercises;

import learn.csia.utils.CliAppArgs;

public class E1812ReverseString {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter string");
        String s = cli.nextString();
        printReversely(s);
    }

    private static void printReversely(String s) {
        printReversely(s, s.length() - 1);
    }

    private static void printReversely(String s, int high) {
        if (high >= 0) {
            System.out.print(s.charAt(high));
            printReversely(s, high - 1);
        }
    }
}
