package learn.mutumju.ch01recall.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestName;

/**
 * Represents an external resource and prints the output in the console.
 * {@code ExternalResource} rule makes the setup and cleanup work the responsibility of the resource.
 */
public class ExternalResourceRuleTest {
    private Resource resource;
    @Rule
    public TestName name = new TestName();
    @Rule
    public ExternalResource rule = new ExternalResource() {
        @Override
        protected void before() {
            resource = new Resource();
            resource.open();
            System.out.println("before " + name.getMethodName());
        }

        @Override
        protected void after() {
            resource.close();
            System.out.println("after " + name.getMethodName() + "\n");
        }
    };

    @Test
    public void testSomething1() {
        System.out.println(resource.get());
    }

    @Test
    public void testSomething2() {
        System.out.println(resource.get());
    }
}
