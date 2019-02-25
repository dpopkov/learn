package learn.core2.ch02io.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDemo {
    public static void main(String[] args) {
        replaceAllDemo();
        replaceAllUsingReferencesToGroups();
    }

    private static void replaceAllUsingReferencesToGroups() {
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
        String input = "one11two22three";
        Matcher m = p.matcher(input);
        String rst = m.replaceAll("_$1_<$2>");
        print("replaceAllUsingReferencesToGroups", p, input, rst);
    }

    private static void replaceAllDemo() {
        System.out.println("\n=== replaceAllDemo ===");
        Pattern p = Pattern.compile("[0-9]+");
        String input = "one11two22three";
        Matcher m = p.matcher(input);
        String rst = m.replaceAll("#");
        print("replaceAllDemo", p, input, rst);
    }

    private static void print(String title, Pattern p, String input, String rst) {
        System.out.println("\n=== " + title + "===");
        System.out.println("Pattern: " + p);
        System.out.println("Input: " + input);
        System.out.println("Result: " + rst);
    }
}
