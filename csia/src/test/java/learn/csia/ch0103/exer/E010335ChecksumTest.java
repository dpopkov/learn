package learn.csia.ch0103.exer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class E010335ChecksumTest {
    @Test
    public void testFindChecksum() {
        String isbn = "020131452";
        int result = new E010335Checksum().findChecksum(isbn);
        assertThat(result, is(5));
    }

    @Test
    public void testFindChecksum2() {
        String isbn = "129173431";
        int result = new E010335Checksum().findChecksum(isbn);
        assertThat(result, is(7));
    }
}