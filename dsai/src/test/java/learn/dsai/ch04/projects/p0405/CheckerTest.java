package learn.dsai.ch04.projects.p0405;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CheckerTest {

    @Test
    public void whenProcessCustomerWith2GroceriesThenNeeds2Calls() {
        Checker checker = new Checker();
        Customer customer = new Customer(1, 2);
        assertThat(checker.process(customer), is(false));
        assertThat(customer.getGroceries(), is(1));
        assertThat(checker.process(customer), is(true));
        assertThat(customer.getGroceries(), is(0));
    }
}