package learn.dsajg6e.ch02oop;

import learn.dsajg6e.ch01primer.CreditCard;

/**
 * CF 2.1
 */
@SuppressWarnings("unused")
public class PredatoryCreditCard extends CreditCard {
    static final double ATTEMPTED_OVERCHARGE_PENALTY = 5.0;

    /** Annual percentage rate. */
    private final double apr;

    public PredatoryCreditCard(String customer, String bank, String account, int limit,
                               double balance, double rate) {
        super(customer, bank, account, limit, balance);
        apr = rate;
    }

    /** Access monthly interest charges. */
    public void processMonth() {
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
    }

    @Override
    public boolean charge(double price) {
        boolean success = super.charge(price);
        if (!success) {
            balance += ATTEMPTED_OVERCHARGE_PENALTY;
        }
        return success;
    }
}
