package learn.ijpds.tools;

import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceBuilderTest {
    @Test
    public void whenTwoWordsThenInsertSpace() {
        SentenceBuilder builder = new SentenceBuilder();
        builder.append("one");
        builder.append("two");
        assertEquals("one two", builder.toString());
    }

    @Test
    public void whenTwoObjectsThenInsertSpace() {
        SentenceBuilder builder = new SentenceBuilder();
        builder.append(1);
        builder.append(2);
        assertEquals("1 2", builder.toString());
    }
}