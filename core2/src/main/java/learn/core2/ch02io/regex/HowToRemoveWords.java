package learn.core2.ch02io.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HowToRemoveWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = in.nextLine();
        String result = removeRepeatedWords(input);
        System.out.println("result = " + result);
    }

    /** Removes repeated words except last word. */
    private static String removeRepeatedWords(String input) {
        String regex = "\\b(\\w+)\\b\\s*(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(input).replaceAll("");
    }
}
