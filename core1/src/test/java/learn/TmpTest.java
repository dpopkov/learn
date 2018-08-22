package learn;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class TmpTest {
    @Test
    public void whenFooThenFoo() {
        Tmp tmp = new Tmp();
        String result = tmp.foo();
        Assert.assertThat(result, is("foo"));
    }
}
