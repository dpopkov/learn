package learn.ptddjp.isbntools;

public class ValidateISBN {
    public boolean checkISBN(String isbn) {
        return checkISBN(toArray(isbn));
    }

    private int[] toArray(String isbn) {
        int[] digits = new int[10];
        for (int i = 9; i >= 0; i--) {
            digits[i] = isbn.charAt(i) - '0';
        }
        return digits;
    }

    private boolean checkISBN(int[] digits) {
        int sum = 0, t = 10;
        for (int i = 0; i < 10; i++, t--) {
            sum += digits[i] * t;
        }
        return sum % 11 == 0;
    }

    private boolean checkISBN2(int[] digits) {
        int i, s = 0, t = 0;
        for (i = 0; i < 10; i++) {
            t += digits[i];
            s += t;
        }
        return s % 11 == 0;
    }
}
