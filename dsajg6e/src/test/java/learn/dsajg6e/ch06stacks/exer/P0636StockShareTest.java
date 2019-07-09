package learn.dsajg6e.ch06stacks.exer;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class P0636StockShareTest {

    @Test
    public void sequenceOfTransactionsRunsInFifoOrder() {
        P0636StockShare stock = new P0636StockShare();
        stock.transaction("buy 100 share(s) at $20 each");
        stock.transaction("buy 20 share(s) at $24 each");
        stock.transaction("buy 200 share(s) at $36 each");
        stock.transaction("sell 150 share(s) at $30 each");
        int gain = stock.capitalGain();
        assertThat(gain, Matchers.is(940));
    }
}

