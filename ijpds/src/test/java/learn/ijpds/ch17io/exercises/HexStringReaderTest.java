package learn.ijpds.ch17io.exercises;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class HexStringReaderTest {

    @Test
    public void parseByteA1() {
        HexStringReader reader = new HexStringReader();
        byte result = reader.parseByte("A1");
        assertThat(result, Is.is((byte) 0xA1));
    }

    @Test
    public void parseByteFF() {
        HexStringReader reader = new HexStringReader();
        byte result = reader.parseByte("FF");
        assertThat(result, Is.is((byte) 0xFF));
    }
}
