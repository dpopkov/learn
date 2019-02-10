package learn.bj6e.ch11io;

import org.junit.Test;

import static learn.bj6e.ch11io.CaesarCipher.encrypt;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CaesarCipherTest {
    @Test
    public void testEncrypt() {
        assertThat(encrypt('a', 3), is('d'));
        assertThat(encrypt('d', -3), is('a'));
        assertThat(encrypt('x', 3), is('a'));
        assertThat(encrypt('a', -3), is('x'));
        assertThat(encrypt('Z', 3), is('C'));
        assertThat(encrypt('C', -3), is('Z'));
    }
}