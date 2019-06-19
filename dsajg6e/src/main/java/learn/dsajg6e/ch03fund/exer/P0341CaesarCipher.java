package learn.dsajg6e.ch03fund.exer;

/**
 * CaesarCipher as a subclass of a substitution cipher.
 */
public class P0341CaesarCipher extends P0340SubstitutionCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public P0341CaesarCipher(int rotation) {
        super(generateEncoding(rotation));
    }

    private static String generateEncoding(int rotation) {
        return ALPHABET.substring(rotation) + ALPHABET.substring(0, rotation);
    }
}
