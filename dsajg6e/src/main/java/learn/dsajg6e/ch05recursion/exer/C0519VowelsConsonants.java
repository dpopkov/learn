package learn.dsajg6e.ch05recursion.exer;

/*
Use recursion to write a Java method for determining if a string s has more vowels
than consonants.
 */
@SuppressWarnings("SpellCheckingInspection")
public class C0519VowelsConsonants {
    static boolean moreVowels(String s) {
        return diff(s) > 0;
    }

    private static int diff(String s) {
        int first = isVowel(s.charAt(0)) ? 1 : -1;
        if (s.length() == 1) {
            return first;
        }
        return first + diff(s.substring(1));
    }

    private final static String VOWELS = "aeiouAEIOU";

    private static boolean isVowel(char c) {
        return VOWELS.indexOf(c) > -1;
    }
}
