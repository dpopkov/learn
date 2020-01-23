package learn.ijpds2nd.ch03select.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0309IsbnTest {

    @Test
    public void testIsbn9ToIsbn10() {
        String isbn10 = E0309Isbn.isbn9ToIsbn10(13601267);
        assertEquals("0136012671", isbn10);

        isbn10 = E0309Isbn.isbn9ToIsbn10(13031997);
        assertEquals("013031997X", isbn10);
    }
}
