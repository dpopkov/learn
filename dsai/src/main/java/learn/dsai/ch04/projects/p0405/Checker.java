package learn.dsai.ch04.projects.p0405;

public class Checker {
    /**
     * Processes a customer, should be invoked until the customer is processed.
     * @return true if the customer is processed
     */
    public boolean process(Customer customer) {
        customer.setGroceries(customer.getGroceries() - 1);
        return customer.getGroceries() == 0;
    }
}
