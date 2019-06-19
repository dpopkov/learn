package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class P0340SubstitutionCipherTest {
    private final static String SUBSTITUTION_LETTERS = "CDEFGHIJKLMNOPQRSTUVWXYZAB";

    @Test
    public void testEncode() {
        String msg = "THE EAGLE";
        P0340SubstitutionCipher cipher = new P0340SubstitutionCipher(SUBSTITUTION_LETTERS);
        String secret = cipher.encrypt(msg);
        String expected = "VJG GCING";
        assertThat(secret, is(expected));
    }

    @Test
    public void testDecode() {
        String secret = "VJG GCING";
        P0340SubstitutionCipher cipher = new P0340SubstitutionCipher(SUBSTITUTION_LETTERS);
        String message = cipher.decrypt(secret);
        String expected = "THE EAGLE";
        assertThat(message, is(expected));
    }
}
