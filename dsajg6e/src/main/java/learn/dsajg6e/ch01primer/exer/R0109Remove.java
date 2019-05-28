package learn.dsajg6e.ch01primer.exer;

import learn.dsajg6e.tools.Input;

/**
 * Write a short Java method that uses a StringBuilder instance to remove all the
 * punctuation from a string.
 */
public class R0109Remove {
    public static void main(String[] args) {
        String s = Input.nextLine("Enter a string: ");
        s = removePunctuation(s);
        System.out.println("Without punctuation: " + s);
    }

    private static String removePunctuation(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); ) {
            char ch = sb.charAt(i);
            if (isPunctuation(ch)) {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    private static boolean isPunctuation(char ch) {
        switch (Character.getType(ch)) {
            case Character.CONNECTOR_PUNCTUATION:
            case Character.DASH_PUNCTUATION:
            case Character.END_PUNCTUATION:
            case Character.FINAL_QUOTE_PUNCTUATION:
            case Character.INITIAL_QUOTE_PUNCTUATION:
            case Character.OTHER_PUNCTUATION:
            case Character.START_PUNCTUATION:
                return true;
            default:
                return false;
        }
    }
}
