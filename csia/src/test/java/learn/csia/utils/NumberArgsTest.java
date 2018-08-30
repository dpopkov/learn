package learn.csia.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class NumberArgsTest {
    @Test
    public void whenIntInArgsThenInt() {
        String[] args = {"3", "77"};
        NumberArgs in = new NumberArgs(args);
        Assert.assertThat(in.nextInt(), is(3));
        Assert.assertThat(in.nextInt(), is(77));
    }

    @Test
    public void whenDoublesInArgsThenDoubles() {
        String[] args = {"3.4", "77.8"};
        NumberArgs in = new NumberArgs(args);
        Assert.assertThat(in.nextDouble(), closeTo(3.4, 0.1));
        Assert.assertThat(in.nextDouble(), closeTo(77.8, 0.1));
    }

    @Test
    public void whenLongsInArgsThenLongs() {
        String[] args = {"3", "21474836489"};
        NumberArgs in = new NumberArgs(args);
        Assert.assertThat(in.nextLong(), is(3L));
        Assert.assertThat(in.nextLong(), is(21474836489L));
    }
}
