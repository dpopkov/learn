package learn.mutumju.ch01recall.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(CrazyTests.class)
@Suite.SuiteClasses({SomeTest.class, OtherTest.class})
public class CrazyTestSuite {
    // Will run SomeTest.b and OtherTest.c, but not SomeTest.a
}
