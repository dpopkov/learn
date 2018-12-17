package learn.dsai.ch11ht.projects;

import org.junit.Test;

import static learn.dsai.ch11ht.projects.P1103Folding.*;
import static org.junit.Assert.*;

public class P1103FoldingTest {

    @Test
    public void testFold() {
        assertEquals(999, fold(999, 3));
        assertEquals(0, fold(1999, 3));
        assertEquals(18, fold(1999, 2));
        assertEquals(21, fold(31999, 2));
    }
}
