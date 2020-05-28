package learn.ijpds2nd.ch10oop;

import java.util.Date;

public class Loan {
    private final double annualInterestRate;
    private final int numberOfYears;
    private final double loanAmount;
    private final Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return (Date) loanDate.clone();
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200.0;
        return loanAmount * monthlyInterestRate
                / (1 - 1.0 / Math.pow(1.0 + monthlyInterestRate, numberOfYears * 12));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}
