package learn.dsajg6e.ch03fund.exer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0342RandomCipherTest {
    @Test
    public void testEncodeDecode() {
        String message = "HELLO WORLD!";

        P0342RandomCipher random1 = new P0342RandomCipher();
        String secret1 = random1.encrypt(message);
        System.out.println("secret1 = " + secret1);
        assertThat(secret1, is(not(message)));
        String decrypted1 = random1.decrypt(secret1);
        assertThat(decrypted1, is(not(secret1)));
        assertThat(decrypted1, is(message));

        P0342RandomCipher random2 = new P0342RandomCipher();
        String secret2 = random2.encrypt(message);
        System.out.println("secret2 = " + secret2);
        assertThat(secret2, is(not(message)));
        String decrypted2 = random2.decrypt(secret2);
        assertThat(decrypted2, is(not(secret2)));
        assertThat(decrypted2, is(message));

        assertThat(secret1, is(not(secret2)));
    }
}