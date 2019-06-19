package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class P0341CaesarCipherTest {
    @Test
    public void testEncryption() {
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE’S.";
        P0341CaesarCipher cipher = new P0341CaesarCipher(3);
        String secret = cipher.encrypt(message);
        assertThat(secret, is("WKH HDJOH LV LQ SODB; PHHW DW MRH’V."));
    }

    @Test
    public void testDecryption() {
        String secret = "WKH HDJOH LV LQ SODB; PHHW DW MRH’V.";
        P0341CaesarCipher cipher = new P0341CaesarCipher(3);
        String message = cipher.decrypt(secret);
        assertThat(message, is("THE EAGLE IS IN PLAY; MEET AT JOE’S."));
    }
}