package learn.ijpds.ch18recursion.exercises;

import learn.csia.utils.CliAppArgs;

public class E1809ReverseString {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "Enter string");
        String s = cli.nextString();
        printReversely(s);
    }

    private static void printReversely(String s) {
        if (s.length() > 0) {
            int last = s.length() - 1;
            System.out.print(s.charAt(last));
            printReversely(s.substring(0, last));
        }
    }
}
