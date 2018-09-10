package learn.csia.ch0103.exer;

import learn.csia.utils.CliAppArgs;

public class E010335Checksum {

    private static final int ISBN_LENGTH_WO_CHECK = 9;

    public int findChecksum(String isbn) {
        if (isbn.length() != ISBN_LENGTH_WO_CHECK) {
            throw new IllegalArgumentException("ISBN without checksum bust have length = 9");
        }
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            char ch = isbn.charAt(i);
            int n = ch - '0';
            sum += n * (10 - i);
        }
        int check = 11 - sum % 11;
        return check == 11 ? 0 : check;
    }

    public String addCheckSumDigit(String isbn) {
        int checksum = findChecksum(isbn);
        String suffix = checksum < 10 ? Integer.toString(checksum) : "X";
        return isbn + suffix;
    }

    public static void main(String[] args) {
        CliAppArgs in = new CliAppArgs(args, "Enter ISBN number as 9-digit integer");
        String isbn = in.nextString();
        E010335Checksum e = new E010335Checksum();
        System.out.println("ISBN: " + e.addCheckSumDigit(isbn));
    }
}
