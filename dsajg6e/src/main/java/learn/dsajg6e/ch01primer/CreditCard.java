package learn.dsajg6e.ch01primer;

/**
 * CF 1.5
 * Models a simplified version of traditional credit card.
 * It stores information about the customer, issuing bank, account identifier, credit limit,
 * and current balance.
 * It does not charge interest or late payments,
 * but it restricts charges that would cause a card’s balance to go over its credit limit.
 */
public class CreditCard {
    private final String customer;
    private final String bank;
    /** Account identifier (e.g., "5391 0375 9387 5309") */
    private final String account;
    /** Credit limit measured in dollars. */
    private final int limit;
    protected double balance;

    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    public CreditCard(String customer, String bank, String account, int limit) {
        this(customer, bank, account, limit, 0.0);
    }

    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        }
        balance += price;
        return true;
    }

    public void makePayment(double amount) {
        balance -= amount;
    }

    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }

    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings",
                "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal",
                "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance",
                "5391 0375 9387 5309", 2500, 300);

        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3 * val);
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card);
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("card.getBalance() = " + card.getBalance());
            }
        }
    }
}
