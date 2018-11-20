package learn.dsai.ch04.parsing;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class ParsePostTest {

    @Test
    public void testParse() {
        ParsePost parser = new ParsePost();
        assertThat(parser.parse("23+"), is(5L));
        assertThat(parser.parse("345+*612+/-"), is(25L));
    }
}
