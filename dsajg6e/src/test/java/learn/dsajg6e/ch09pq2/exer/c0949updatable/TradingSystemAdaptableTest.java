package learn.dsajg6e.ch09pq2.exer.c0949updatable;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TradingSystemAdaptableTest {

    @Test
    public void whenEnterBuyAndSellWithGreaterPriceAntLaterLowerPriceThenProcessed() {
        TradingSystemAdaptable system = new TradingSystemAdaptable();
        OrderAdapt buy3 = OrderAdapt.buy(100, 3);
        system.enter(buy3);
        OrderAdapt sell = OrderAdapt.sell(100, 5);
        system.enter(sell);
        assertThat(buy3.isProcessed(), is(false));
        assertThat(sell.isProcessed(), is(false));

        sell.setPrice(3);
        assertThat(buy3.isProcessed(), is(true));
        assertThat(sell.isProcessed(), is(true));
    }

    @Test
    public void whenEnterBuyAndSellWithGreaterPriceAndLaterRaisePriceThenProcessed() {
        TradingSystemAdaptable system = new TradingSystemAdaptable();
        OrderAdapt sell3 = OrderAdapt.sell(200, 7);
        system.enter(sell3);
        OrderAdapt buy = OrderAdapt.buy(200, 5);
        system.enter(buy);
        system.enter(OrderAdapt.buy(200, 6));
        assertThat(sell3.isProcessed(), is(false));
        assertThat(buy.isProcessed(), is(false));

        buy.setPrice(8);
        assertThat(sell3.isProcessed(), is(true));
        assertThat(buy.isProcessed(), is(true));
    }
}
