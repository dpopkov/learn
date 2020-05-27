package learn.ijpds2nd.ch07arrays.exer;

import learn.ijpds2nd.tools.ConsoleInput;

public class E0722CountVowels {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        String s = in.requestLine("Enter a string: ");
        int count = countVowels(s);
        System.out.println("Number of vowels = " + count);
    }

    private static int countVowels(String s) {
        int count = 0;
        final char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            boolean isVowel = false;
            for (char vowel : vowels) {
                if (ch == vowel) {
                    isVowel = true;
                    break;
                }
            }
            if (isVowel) {
                count++;
            }
        }
        return count;
    }
}
