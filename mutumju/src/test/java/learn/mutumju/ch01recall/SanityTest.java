package learn.mutumju.ch01recall;

import org.junit.*;

/**
 * Demonstrates usage of {@code @BeforeClass, @Before, @Test, @After, @AfterClass} annotations.
 */
public class SanityTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("***Before Class is invoked");
    }

    @Before
    public void before() {
        System.out.println("------------------------");
        System.out.println("\t Before is invoked");
    }

    @Test
    public void someTest() {
        TmpResearch tr;
        System.out.println("\t\t someTest is invoked");
    }

    @Test
    public void someTest2() {
        System.out.println("\t\t someTest2 is invoked");
    }

    @After
    public void after() {
        System.out.println("\t After is invoked");
        System.out.println("=========================");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("***After class is invoked");
    }
}
