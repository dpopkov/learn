package learn.dsajg6e.ch09pq2.exer.c0948trading;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TradingSystemTest {

    @Test
    public void buyOrderCanBeProcessedIfThereIsSellOrderWithPriceNotGreater() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order buyOrder = new Order("buy 100 shares at $5 each");
        assertThat(buyOrder.isProcessed(), is(false));
        system.enter(new Order("sell 100 shares at $3 each"));
        system.enter(buyOrder);
        assertThat(buyOrder.isProcessed(), is(true));
    }

    @Test
    public void buyOrderCanBeProcessedIfLaterIsAddedSellOrderWithPriceNotGreater() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order buyOrder = new Order("buy 100 shares at $5 each");
        system.enter(buyOrder);
        assertThat(buyOrder.isProcessed(), is(false));
        system.enter(new Order("sell 100 shares at $7 each"));
        assertThat(buyOrder.isProcessed(), is(false));
        system.enter(new Order("sell 100 shares at $3 each"));
        assertThat(buyOrder.isProcessed(), is(true));
    }

    @Test
    public void sellOrderCanBeProcessedIfThereIsBuyOrderWithPriceNotLess() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order selling = Order.sell(200, 3);
        assertThat(selling.isProcessed(), is(false));
        system.enter(Order.buy(200, 3));
        system.enter(selling);
        assertThat(selling.isProcessed(), is(true));
    }

    @Test
    public void sellOrderCanNotBeProcessedIfThereIsBuyOrderWithPriceLess() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order selling = Order.sell(100, 5);
        assertThat(selling.isProcessed(), is(false));
        system.enter(Order.buy(100, 4));
        system.enter(selling);
        assertThat(selling.isProcessed(), is(false));
    }

    @Test
    public void ifSellOrderAddedToSystemWithTwoBuyingOrdersItIsProcessedWithGreater() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order sellBy5 = Order.sell(100, 5);
        assertThat(sellBy5.isProcessed(), is(false));
        Order buyBy5 = Order.buy(100, 5);
        system.enter(buyBy5);
        assertThat(buyBy5.isProcessed(), is(false));
        system.enter(Order.buy(100, 4));
        system.enter(sellBy5);
        assertThat(sellBy5.isProcessed(), is(true));
        assertThat(buyBy5.isProcessed(), is(true));
    }

    @Test
    public void ifSystemHasSellingGreaterThenWaitUntilAddSellingLess() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order sellBy5 = Order.sell(100, 5);
        system.enter(sellBy5);
        Order buyBy3 = Order.buy(100, 3);
        system.enter(buyBy3);
        assertThat(buyBy3.isProcessed(), is(false));
        Order buyBy5 = Order.buy(100, 5);
        system.enter(buyBy5);
        assertThat(sellBy5.isProcessed(), is(true));
        assertThat(buyBy5.isProcessed(), is(true));
        assertThat(buyBy3.isProcessed(), is(false));
    }

    @Test
    public void ifSystemHasBuyOrderLessThanSellOrderThenSellOrderProcessedLater() {
        TradingSystem<Order> system = new TradingSystem<>();
        Order buyBy3 = Order.buy(100, 3);
        system.enter(buyBy3);
        Order sellBy5 = Order.sell(100, 5);
        system.enter(sellBy5);
        Order buyBy5 = Order.buy(100, 5);
        system.enter(buyBy5);
        assertThat(sellBy5.isProcessed(), is(true));
        assertThat(buyBy5.isProcessed(), is(true));
        assertThat(buyBy3.isProcessed(), is(false));
    }
}
