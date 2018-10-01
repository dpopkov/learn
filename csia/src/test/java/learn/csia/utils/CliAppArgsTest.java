package learn.csia.utils;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class CliAppArgsTest {

    private static final InputStream STANDARD_INPUT = System.in;

    @Test
    public void whenIntInArgsThenInt() {
        String[] args = {"3", "77"};
        CliAppArgs in = new CliAppArgs(args);
        Assert.assertThat(in.nextInt(), is(3));
        Assert.assertThat(in.nextInt(), is(77));
    }

    @Test
    public void whenDoublesInArgsThenDoubles() {
        String[] args = {"3.4", "77.8"};
        CliAppArgs in = new CliAppArgs(args);
        Assert.assertThat(in.nextDouble(), closeTo(3.4, 0.1));
        Assert.assertThat(in.nextDouble(), closeTo(77.8, 0.1));
    }

    @Test
    public void whenLongsInArgsThenLongs() {
        String[] args = {"3", "21474836489"};
        CliAppArgs in = new CliAppArgs(args);
        Assert.assertThat(in.nextLong(), is(3L));
        Assert.assertThat(in.nextLong(), is(21474836489L));
    }

    @Test
    public void whenStringsInArgsThenStrings() {
        String[] args = {"Jack", "Sparrow"};
        CliAppArgs in = new CliAppArgs(args);
        Assert.assertThat(in.nextString(), is("Jack"));
        Assert.assertThat(in.nextString(), is("Sparrow"));
    }

    @Test
    public void whenLineInStandardInputThenGetLine() {
        String inputString = "One input line";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        CliAppArgs in = new CliAppArgs(new String[] {}, "prompt");
        String result = in.nextLine();
        Assert.assertThat(result, Is.is(inputString));

        System.setIn(STANDARD_INPUT);
    }

    @Test
    public void whenLineInArgsThenGetLine() {
        CliAppArgs cli = new CliAppArgs(new String[]{"\"One", "input", "line\""}, "prompt");
        String result = cli.nextLine();
        Assert.assertThat(result, Is.is("One input line"));
    }

    @Test
    public void whenOneWordInArgsThenGetLine() {
        CliAppArgs cli = new CliAppArgs(new String[]{"One"}, "prompt");
        String result = cli.nextLine();
        Assert.assertThat(result, Is.is("One"));
    }

    @Test
    public void whenLineInStandardInputThenPrompt() {
        String inputString = "One input line";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        PrintStream stdOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        CliAppArgs in = new CliAppArgs(new String[] {}, "prompt42");
        String result = in.nextLine();
        Assert.assertThat(result, Is.is(inputString));
        Assert.assertThat(baos.toString(), Is.is("prompt42: "));

        System.setIn(STANDARD_INPUT);
        System.setOut(stdOut);
    }
}
