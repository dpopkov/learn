package learn.dsajg6e.ch03fund;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class CaesarCipherTest {

    @Test
    public void testEncryption() {
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE’S.";
        CaesarCipher cipher = new CaesarCipher(3);
        String secret = cipher.encrypt(message);
        assertThat(secret, is("WKH HDJOH LV LQ SODB; PHHW DW MRH’V."));
    }

    @Test
    public void testDecryption() {
        String secret = "WKH HDJOH LV LQ SODB; PHHW DW MRH’V.";
        CaesarCipher cipher = new CaesarCipher(3);
        String message = cipher.decrypt(secret);
        assertThat(message, is("THE EAGLE IS IN PLAY; MEET AT JOE’S."));
    }
}
