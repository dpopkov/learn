package learn.dsajg6e.ch03fund;

/**
 * CF 3.8
 */
public class CaesarCipher {
    public enum Alphabet {
        ENGLISH("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"),
        RUSSIAN("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯабвгдеёжзийклмнопрстуфхцчшщьыъэюя");

        private final String letters;

        Alphabet(String letters) {
            this.letters = letters;
        }

        public char[] toChars() {
            return letters.toCharArray();
        }
    }

    private final char[] alphabetChars;
    private final char[] encoder;
    private final char[] decoder;

    public CaesarCipher(int rotation, Alphabet alphabet) {
        alphabetChars = alphabet.toChars();
        int size = alphabetChars.length;
        encoder = new char[size];
        decoder = new char[size];
        for (int i = 0; i < size; i++) {
            encoder[i] = alphabetChars[(i + rotation) % size];
            decoder[i] = alphabetChars[(i - rotation + size) % size];
        }
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    private String transform(String s, char[] code) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = indexInAlphabet(chars[i]);
            if (index >= 0) {
                chars[i] = code[index];
            }
        }
        return new String(chars);
    }

    private int indexInAlphabet(char aChar) {
        for (int i = 0; i < alphabetChars.length; i++) {
            if (alphabetChars[i] == aChar) {
                return i;
            }
        }
        return -1;
    }
}
