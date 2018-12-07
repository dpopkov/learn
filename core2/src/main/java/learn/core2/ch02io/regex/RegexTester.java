/* 2.6 */
package learn.core2.ch02io.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tests regular expression matching.
 * Enter a pattern and strings to match, or hit 'Enter' to exit.
 * If the pattern contains groups, the group boundaries are displayed.
 */
public class RegexTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter pattern: ");
        String patternString = in.nextLine();
        Pattern pattern = Pattern.compile(patternString);
        while (true) {
            System.out.print("Enter string to match: ");
            String input = in.nextLine();
            if (input == null || input.isEmpty()) {
                return;
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Match");
                MatchedFormatter formatter = new MatchedFormatter(matcher);
                System.out.println(formatter.formatInGroups(input));
            } else {
                System.out.println("No match");
            }
        }
    }
}
