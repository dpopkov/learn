package learn.mutumju.ch01recall;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Executing tests in order.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutionOrderTest {
    @Test
    public void edit() {
        System.out.println("edit executed");
    }

    @Test
    public void create() {
        System.out.println("create executed");
    }

    @Test
    public void remove() {
        System.out.println("remove executed");
    }
}
