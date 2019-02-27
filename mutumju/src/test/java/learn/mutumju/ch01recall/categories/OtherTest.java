package learn.mutumju.ch01recall.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({CrazyTests.class, SmartTests.class})
public class OtherTest {
    @Test
    @SuppressWarnings("EmptyMethod")
    public void c() {
    }
}
