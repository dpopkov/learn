package learn.core1.ch03;

public class CompoundInterest {
    public static void main(String[] args) {
        final double START_RATE = 10;
        final int NUM_RATES = 6;
        final int NUM_YEARS = 10;

        double[] interestRate = new double[NUM_RATES];
        for (int j = 0; j < interestRate.length; j++) {
            interestRate[j] = (START_RATE + j) / 100.0;
        }
        double[][] balances = new double[NUM_YEARS][NUM_RATES];

        for (int j = 0; j < balances[0].length; j++) {
            balances[0][j] = 10_000;
        }

        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                double oldBalance = balances[i - 1][j];
                double interest = oldBalance * interestRate[j];
                balances[i][j] = oldBalance + interest;
            }
        }

        for (double rate : interestRate) {
            System.out.printf("%9.0f%%", 100 * rate);
        }
        System.out.println();

        for (double[] row : balances) {
            for (double b : row) {
                System.out.printf("%10.2f", b);
            }
            System.out.println();
        }

    }
}
