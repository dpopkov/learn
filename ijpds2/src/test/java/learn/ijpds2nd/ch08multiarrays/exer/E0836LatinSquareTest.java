package learn.ijpds2nd.ch08multiarrays.exer;

import learn.ijpds2nd.tools.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("SpellCheckingInspection")
public class E0836LatinSquareTest {

    @Test
    public void testIsLatinSquareTrue() {
        char[][] a = ArrayUtils.parseToCharCharArray(""
        + "ABCD\n"
        + "BADC\n"
        + "CDBA\n"
        + "DCAB\n"
        );
        boolean r = new E0836LatinSquare().isLatinSquare(a);
        assertTrue(r);
    }

    @Test
    public void testIsLatinSquareFalse() {
        char[][] a = ArrayUtils.parseToCharCharArray(""
                + "ABCA\n"
                + "BADC\n"
                + "CDBA\n"
                + "DCAB\n"
        );
        boolean r = new E0836LatinSquare().isLatinSquare(a);
        assertFalse(r);
    }

    @Test
    public void testIsLatinSquareFalseByColumn() {
        char[][] a = ArrayUtils.parseToCharCharArray(""
                + "ABCD\n"
                + "ABCD\n"
                + "CDBA\n"
                + "DCAB\n"
        );
        boolean r = new E0836LatinSquare().isLatinSquare(a);
        assertFalse(r);
    }

    @Test
    public void testIsLatinSquareHavingInvalidCharactersFalse() {
        char[][] a = ArrayUtils.parseToCharCharArray(""
                + "ABCE\n"
                + "BADC\n"
                + "CDBA\n"
                + "DCAB\n"
        );
        boolean r = new E0836LatinSquare().isLatinSquare(a);
        assertFalse(r);
    }
}
