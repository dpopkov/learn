package learn.dsajg6e.ch03fund.exer;

public class P0340SubstitutionCipher {
    protected static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char FIRST_CHAR = ALPHABET.charAt(0);
    protected static final int ALPHABET_LENGTH = ALPHABET.length();

    private final char[] encoding;
    private final char[] decoding;

    public P0340SubstitutionCipher(String encodingUpperCaseLetters) {
        if (encodingUpperCaseLetters.length() != ALPHABET_LENGTH) {
            throw new IllegalArgumentException("Encoding letters must be "
                    + ALPHABET_LENGTH + " letters in an arbitrary order");
        }
        encoding = encodingUpperCaseLetters.toCharArray();
        decoding = deriveDecoding(encoding);
    }

    private char[] deriveDecoding(char[] encoding) {
        char[] chars = new char[encoding.length];
        for (int i = 0; i < encoding.length; i++) {
            char encoded = encoding[i];
            int pos = encoded - FIRST_CHAR;
            chars[pos] = (char) (FIRST_CHAR + i);
        }
        return chars;
    }

    public String encrypt(String message) {
        return transform(message, encoding);
    }

    public String decrypt(String secret) {
        return transform(secret, decoding);
    }

    private String transform(String source, char[] transformation) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isUpperCase(ch)) {
                int pos = ch - FIRST_CHAR;
                chars[i] = transformation[pos];
            }
        }
        return new String(chars);
    }
}
