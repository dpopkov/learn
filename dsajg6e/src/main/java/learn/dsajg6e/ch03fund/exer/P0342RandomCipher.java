package learn.dsajg6e.ch03fund.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P0342RandomCipher extends P0340SubstitutionCipher {
    public P0342RandomCipher() {
        super(generateRandomEncodingLetters());
    }

    private static String generateRandomEncodingLetters() {
        List<Character> chars = new ArrayList<>(ALPHABET_LENGTH);
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            chars.add(ALPHABET.charAt(i));
        }
        Collections.shuffle(chars);
        char[] charsArr = new char[ALPHABET_LENGTH];
        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            charsArr[i] = chars.get(i);
        }
        return new String(charsArr);
    }
}
