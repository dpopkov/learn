package learn.core2.ch02io.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tests regular expression matching.
 * Usage: enter a pattern and strings to match, or hit Cancel to exit.
 * If the pattern contains groups, the group boundaries are displayed in the match.
 */
public class RegexDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter pattern: ");
        String regex = in.nextLine();
        Pattern pattern = Pattern.compile(regex);
        MatcherFormatter formatter = new MatcherFormatter();
        while (true) {
            System.out.print("Enter string to match: ");
            String input = in.nextLine();
            if (input == null || input.isBlank()) {
                return;
            }
            Matcher matcher = pattern.matcher(input);
            System.out.println(formatter.format(matcher, input));
        }
    }
}