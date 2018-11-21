package learn.dsai.ch04.projects.p0405;

import java.util.LinkedList;
import java.util.Queue;

public class CheckoutLine {
    private final Queue<Customer> queue = new LinkedList<>();
    private final Checker checker = new Checker();

    public void add(Customer customer) {
        queue.add(customer);
    }

    public void tick() {
        if (!queue.isEmpty()) {
            Customer first = queue.element();
            if (checker.process(first)) {
                queue.remove();
            }
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
