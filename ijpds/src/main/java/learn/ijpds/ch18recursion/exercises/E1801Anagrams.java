package learn.ijpds.ch18recursion.exercises;

import learn.csia.utils.CliAppArgs;

public class E1801Anagrams {
    public static void main(String[] args) {
        CliAppArgs cli = new CliAppArgs(args, "First word", "Second word");
        String w1 = cli.nextString();
        String w2 = cli.nextString();
        boolean r = anagrams(w1, w2);
        System.out.printf("%s and %s are%s anagrams%n", w1, w2, r ? "" : " not");
    }

    /**
     * Non-efficient implementation of recursive method that identifies if two given
     * words are anagrams of each other.
     * @param w1 first word
     * @param w2 second word
     * @return true if anagrams, false otherwise
     */
    public static boolean anagrams(String w1, String w2) {
        if (w1.length() == 1 && w2.length() == 1 && w1.equals(w2)) {
            return true;
        } else if (w1.length() == 0 || w2.length() == 0) {
            return false;
        }
        int pos = w2.indexOf(w1.charAt(0));
        if (pos == -1) {
            return false;
        }
        return anagrams(w1.substring(1), w2.substring(0, pos) + w2.substring(pos + 1));
    }
}
