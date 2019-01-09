package learn.hackerrank.java.days30.d26;

import learn.hackerrank.utils.InputStreamBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class LibraryFeeTest {
    private PrintStream savedOut;
    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        savedOut = System.out;
        System.setOut(new PrintStream(buffer));
    }

    @After
    public void restoreOut() {
        System.setOut(savedOut);
    }

    @Test
    public void whenAfter3DaysThen45() {
        setInput(new int[]{9, 6, 2015},
                new int[]{6, 6, 2015});
        LibraryFee.main(null);
        assertAnswer(45);
    }

    @Test
    public void whenBeforeDueThenZeroFine() {
        setInput(new int[]{5, 6, 2015},
                new int[]{6, 6, 2015});
        LibraryFee.main(null);
        assertAnswer(0);
    }

    @Test
    public void whenOnTimeThenZeroFine() {
        setInput(new int[]{6, 6, 2015},
                new int[]{6, 6, 2015});
        LibraryFee.main(null);
        assertAnswer(0);
    }

    @Test
    public void whenAfterDueMonthThen500PerMonth() {
        setInput(new int[]{6, 8, 2015},
                new int[]{6, 7, 2015});
        LibraryFee.main(null);
        assertAnswer(500);
    }

    @Test
    public void whenOtherYearThen10000() {
        setInput(new int[]{6, 7, 2016},
                new int[]{6, 6, 2015});
        LibraryFee.main(null);
        assertAnswer(10000);
    }

    private void setInput(int[] actual, int[] due) {
        InputStreamBuilder builder = new InputStreamBuilder();
        builder.appendLn(actual);
        builder.appendLn(due);
        System.setIn(builder.getInputStream());
    }

    private void assertAnswer(int expected) {
        String answer = buffer.toString();
        assertThat(answer, is(expected + System.lineSeparator()));
    }
}
