package learn.dsajg6e.ch02oop.exer;

import learn.dsajg6e.ch01primer.CreditCard;

/**
 * C-2.18
 * Once a customer has made 10 calls to charge during a month,
 * each additional call to that method in the current month
 * results in an additional $1 surcharge.
 */
public class C0218PredatoryCreditCard extends CreditCard {
    static final double ATTEMPTED_OVERCHARGE_PENALTY = 5.0;
    static final int CHARGES_PER_MONTH_LIMIT = 10;
    static final double MONTH_LIMIT_SURCHARGE = 1.0;

    /** Annual percentage rate. */
    private final double apr;
    private int numChargesPerMonth;

    public C0218PredatoryCreditCard(String customer, String bank, String account, int limit,
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
        numChargesPerMonth = 0;
    }

    @Override
    public boolean charge(double price) {
        boolean success = super.charge(price);
        if (!success) {
            balance += ATTEMPTED_OVERCHARGE_PENALTY;
        }
        numChargesPerMonth++;
        if (numChargesPerMonth > CHARGES_PER_MONTH_LIMIT) {
            balance += MONTH_LIMIT_SURCHARGE;
        }
        return success;
    }
}
