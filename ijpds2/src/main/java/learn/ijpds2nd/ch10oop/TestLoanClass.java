package learn.ijpds2nd.ch10oop;

import learn.ijpds2nd.tools.ConsoleInput;

/* Listing 10.1 */
public class TestLoanClass {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        double annualInterestRate = input.requestDouble("Enter annual interest rate, for example, 8.25: ");
        int numberOfYears = input.requestInt("Enter number of years as an integer: ");
        double loanAmount = input.requestDouble("Enter loan amount, for example, 120000.95: ");
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        System.out.printf("The loan was created on %s%nThe monthly payment is %.2f%nThe total payment is %.2f%n",
                loan.getLoanDate().toString(), loan.getMonthlyPayment(), loan.getTotalPayment());
    }
}
