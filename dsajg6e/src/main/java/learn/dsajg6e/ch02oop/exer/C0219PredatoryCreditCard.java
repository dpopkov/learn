package learn.dsajg6e.ch02oop.exer;

import learn.dsajg6e.ch01primer.CreditCard;

/**
 * A customer is assigned a minimum monthly payment, as a percentage of the balance.
 * A late fee is assessed if the customer does not pay that minimum amount
 * before the next month.
 */
@SuppressWarnings("unused")
public class C0219PredatoryCreditCard extends CreditCard {
    static final double ATTEMPTED_OVERCHARGE_PENALTY = 5.0;

    /** Annual percentage rate. */
    private final double apr;
    /** Minimum monthly payment as a percentage of the balance. */
    private final double minPaymentPerMonth;
    /** Total monthly payments. */
    private double monthlyPayments;

    public C0219PredatoryCreditCard(String customer, String bank, String account, int limit,
                                    double balance, double rate, double minPaymentPerMonth) {
        super(customer, bank, account, limit, balance);
        apr = rate;
        this.minPaymentPerMonth = minPaymentPerMonth;
    }

    /** Access monthly interest charges. */
    public void processMonth() {
        if (balance > 0 && monthlyPayments < balance * minPaymentPerMonth) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
        monthlyPayments = 0.0;
    }

    @Override
    public boolean charge(double price) {
        boolean success = super.charge(price);
        if (!success) {
            balance += ATTEMPTED_OVERCHARGE_PENALTY;
        }
        return success;
    }

    @Override
    public void makePayment(double amount) {
        super.makePayment(amount);
        monthlyPayments += amount;
    }
}
