package learn.ijpds.ch18recursion.exercises;

import java.util.Scanner;

public class E1823BinToDec {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter binary number: ");
        String bin = in.nextLine();
        int n = binToDec(bin);
        System.out.println("n = " + n);
    }

    private static int binToDec(String bin) {
        if (bin.length() == 0) {
            return 0;
        }
        return binToDec(bin, 0, 0);
    }

    private static int binToDec(String bin, int pos, int acc) {
        if (pos > bin.length() - 1) {
            return acc;
        }
        int digit = bin.charAt(pos) - '0';
        return binToDec(bin, pos + 1, acc * 2 + digit);
    }
}
