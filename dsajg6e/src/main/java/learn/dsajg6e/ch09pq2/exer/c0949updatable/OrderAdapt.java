package learn.dsajg6e.ch09pq2.exer.c0949updatable;

import learn.dsajg6e.ch09pq2.exer.c0948trading.Order;

import java.util.function.Consumer;

/**
 * Order with updatable price.
 */
public class OrderAdapt extends Order {
    private Consumer<OrderAdapt> consumer;

    public OrderAdapt(Order.Type type, int numShares, int price) {
        super(type, numShares, price);
    }

    public void setConsumer(Consumer<OrderAdapt> consumer) {
        this.consumer = consumer;
    }

    public void setPrice(int price) {
        this.price = price;
        consumer.accept(this);
    }

    static OrderAdapt buy(int numShares, int price) {
        return new OrderAdapt(Type.BUY, numShares, price);
    }

    static OrderAdapt sell(int numShares, int price) {
        return new OrderAdapt(Type.SELL, numShares, price);
    }
}
