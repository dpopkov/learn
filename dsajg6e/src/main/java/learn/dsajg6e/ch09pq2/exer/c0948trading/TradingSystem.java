package learn.dsajg6e.ch09pq2.exer.c0948trading;

import learn.dsajg6e.ch09pq2.HeapPriorityQueue;
import learn.dsajg6e.ch09pq2.PriorityQueue;

import java.util.Comparator;

public class TradingSystem {
    private static final Comparator<Integer> MAXIMUM_FIRST = (a, b) -> Integer.compare(b, a);

    private final PriorityQueue<Integer, Order> sellingQueue = new HeapPriorityQueue<>();
    private final PriorityQueue<Integer, Order> buyingQueue = new HeapPriorityQueue<>(MAXIMUM_FIRST);

    public void enter(Order order) {
        if (order.getType() == Order.Type.BUY) {
            if (!sellingQueue.isEmpty()
                    && pairIsEligibleToProcess(order, sellingQueue.min().getValue())) {
                Order selling = sellingQueue.removeMin().getValue();
                order.setProcessed(true);
                selling.setProcessed(true);
            } else {
                buyingQueue.insert(order.getPrice(), order);
            }
        } else if (order.getType() == Order.Type.SELL) {
            if (!buyingQueue.isEmpty()
                    && pairIsEligibleToProcess(buyingQueue.min().getValue(), order)) {
                Order buy = buyingQueue.removeMin().getValue();
                buy.setProcessed(true);
                order.setProcessed(true);
            } else {
                sellingQueue.insert(order.getPrice(), order);
            }
        } else {
            throw new IllegalStateException("Unknown order type: " + order.getType());
        }
    }

    private boolean pairIsEligibleToProcess(Order buying, Order selling) {
        return buying.getPrice() >= selling.getPrice()
                && buying.getNumShares() == selling.getNumShares();
    }
}
