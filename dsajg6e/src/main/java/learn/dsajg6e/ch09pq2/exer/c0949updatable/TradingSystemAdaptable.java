package learn.dsajg6e.ch09pq2.exer.c0949updatable;

import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch09pq2.HeapAdaptablePriorityQueue;
import learn.dsajg6e.ch09pq2.exer.c0948trading.Order;
import learn.dsajg6e.ch09pq2.exer.c0948trading.TradingSystem;

/**
 * Trading system that operates orders with updatable prices.
 */
public class TradingSystemAdaptable extends TradingSystem<OrderAdapt> {
    private final HeapAdaptablePriorityQueue<Integer, OrderAdapt> sellingQueue = new HeapAdaptablePriorityQueue<>();
    private final HeapAdaptablePriorityQueue<Integer, OrderAdapt> buyingQueue = new HeapAdaptablePriorityQueue<>(MAXIMUM_FIRST);

    @Override
    public void enter(OrderAdapt order) {
        if (order.getType() == Order.Type.BUY) {
            if (!sellingQueue.isEmpty()
                    && pairIsEligibleToProcess(order, sellingQueue.min().getValue())) {
                Order selling = sellingQueue.removeMin().getValue();
                order.setProcessed(true);
                selling.setProcessed(true);
            } else {
                Entry<Integer, OrderAdapt> entry = buyingQueue.insert(order.getPrice(), order);
                order.setConsumer((o) -> {
                    buyingQueue.replaceKey(entry, o.getPrice());
                    checkPendingOrders();
                });
            }
        } else if (order.getType() == Order.Type.SELL) {
            if (!buyingQueue.isEmpty()
                    && pairIsEligibleToProcess(buyingQueue.min().getValue(), order)) {
                Order buy = buyingQueue.removeMin().getValue();
                buy.setProcessed(true);
                order.setProcessed(true);
            } else {
                Entry<Integer, OrderAdapt> entry = sellingQueue.insert(order.getPrice(), order);
                order.setConsumer((o) -> {
                    sellingQueue.replaceKey(entry, o.getPrice());
                    checkPendingOrders();
                });
            }
        } else {
            throw new IllegalStateException("Unknown order type: " + order.getType());
        }
    }

    private void checkPendingOrders() {
        if (!sellingQueue.isEmpty() && !buyingQueue.isEmpty()) {
            OrderAdapt sell = sellingQueue.min().getValue();
            OrderAdapt buy = buyingQueue.min().getValue();
            if (pairIsEligibleToProcess(buy, sell)) {
                sell = sellingQueue.removeMin().getValue();
                buy = buyingQueue.removeMin().getValue();
                sell.setProcessed(true);
                buy.setProcessed(true);
            }
        }
    }
}
