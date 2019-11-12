package learn.dsajg6e.ch10maps.exer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class C1061InvertedFileTest {

    @Test
    public void testIndicesForWord() {
        String text = "Quick brown fox jumps over a lazy fox";
        List<String> doc = Arrays.asList(text.split("\\s"));
        C1061InvertedFile file = new C1061InvertedFile(doc);
        assertThat(file.indicesForWord("Quick"), is(List.of(0)));
        assertThat(file.indicesForWord("fox"), is(List.of(2, 7)));
        assertThat(file.indicesForWord("jumps"), is(List.of(3)));
    }
}
