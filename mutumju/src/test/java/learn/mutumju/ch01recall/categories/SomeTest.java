package learn.mutumju.ch01recall.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

public class SomeTest {
    @Test
    public void a() {
        fail();
    }

    @Category(CrazyTests.class)
    @Test
    @SuppressWarnings("EmptyMethod")
    public void b() {
    }
}
