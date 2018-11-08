package learn.dsai.ch01;

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0);
        System.out.print("Before transactions, ");
        account.display();

        account.deposit(74.35);
        account.withdraw(20.0);

        System.out.print("After transactions, ");
        account.display();
    }
}
