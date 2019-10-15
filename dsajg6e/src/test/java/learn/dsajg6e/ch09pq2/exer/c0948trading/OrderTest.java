package learn.dsajg6e.ch09pq2.exer.c0948trading;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void canInstantiateBuyOrders() {
        Order order = new Order("buy 100 shares at $5 each");
        assertThat(order.getType(), is(Order.Type.BUY));
        assertThat(order.getNumShares(), is(100));
        assertThat(order.getPrice(), is(5));
    }

    @Test
    public void canInstantiateSellOrders() {
        Order order = new Order("sell 12 shares at $42 each");
        assertThat(order.getType(), is(Order.Type.SELL));
        assertThat(order.getNumShares(), is(12));
        assertThat(order.getPrice(), is(42));
    }
}
