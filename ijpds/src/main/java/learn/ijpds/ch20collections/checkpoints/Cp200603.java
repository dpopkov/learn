/* Check point 20.6.3 */
package learn.ijpds.ch20collections.checkpoints;

import learn.ijpds.ch10oop.Loan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cp200603 {
    public static void main(String[] args) {
        List<Loan> loans = new ArrayList<>(3);
        loans.add(new Loan(5.5, 10, 100));
        loans.add(new Loan(5.0, 10, 2000));
        loans.add(new Loan(5.0, 5, 2000));
        loans.add(new Loan(5.0, 10, 1000));
        System.out.println("Initial:");
        loans.forEach(System.out::println);
//        loans.sort((o1, o2) -> Double.compare(o1.getAnnualInterestRate(), o2.getAnnualInterestRate()));
//        loans.sort(Comparator.comparingDouble(Loan::getAnnualInterestRate));
        loans.sort(Comparator
                .comparingDouble(Loan::getAnnualInterestRate)
                .thenComparingDouble(Loan::getLoanAmount)
                .thenComparingInt(Loan::getNumberOfYears));
        System.out.println("Sorted:");
        loans.forEach(System.out::println);
    }
}
