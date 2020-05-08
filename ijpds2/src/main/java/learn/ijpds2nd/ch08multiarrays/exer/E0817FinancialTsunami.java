package learn.ijpds2nd.ch08multiarrays.exer;

import java.util.Locale;
import java.util.Scanner;

public class E0817FinancialTsunami {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Enter number of banks and limit: ");
        int numBanks = in.nextInt();
        int limit = in.nextInt();
        System.out.println("Enter info for " + numBanks + " banks:");
        double[][] borrowers = new double[numBanks][numBanks];
        double[] banks = new double[numBanks];
        for (int bankIdx = 0; bankIdx < borrowers.length; bankIdx++) {
            int balance = in.nextInt();
            banks[bankIdx] = balance;
            int numBorrowers = in.nextInt();
            for (int i = 0; i < numBorrowers; i++) {
                int borrower = in.nextInt();
                double amount = in.nextDouble();
                borrowers[bankIdx][borrower] = amount;
            }
        }
        for (int bankIdx = 0; bankIdx < banks.length; bankIdx++) {
            checkUnsafeBank(limit, borrowers, banks, bankIdx);
        }
    }

    private static void checkUnsafeBank(int limit, double[][] borrowers, double[] banks, int bankIdx) {
        double totalAssets = banks[bankIdx];
        for (int i = 0; i < banks.length; i++) {
            totalAssets += borrowers[bankIdx][i];
        }
        if (totalAssets < limit) {
            zeroBorrowers(limit, borrowers, banks, bankIdx);
            System.out.println("Bank " + bankIdx + " is unsafe");
        }
    }

    private static void zeroBorrowers(int limit, double[][] borrowers, double[] banks, int bankruptIdx) {
        for (int j = 0; j < borrowers[bankruptIdx].length; j++) {
            if (borrowers[j][bankruptIdx] > 0) {
                borrowers[j][bankruptIdx] = 0;
                checkUnsafeBank(limit, borrowers, banks, j);
            }
        }
    }
}
