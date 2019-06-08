package learn.dsajg6e.ch03fund;

/**
 * CF 3.8
 */
public class CaesarCipher {
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int SIZE = alphabet.length;

    private final char[] encoder = new char[SIZE];
    private final char[] decoder = new char[SIZE];

    public CaesarCipher(int rotation) {
        for (int i = 0; i < SIZE; i++) {
            encoder[i] = alphabet[(i + rotation) % SIZE];
            decoder[i] = alphabet[(i - rotation + SIZE) % SIZE];
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
            if (Character.isUpperCase(chars[i])) {
                chars[i] = code[chars[i] - 'A'];
            }
        }
        return new String(chars);
    }
}
