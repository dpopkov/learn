package learn.ptddjp.isbntools;

public class ValidateISBN {
    private static final int ISBN_SHORT = 10;
    private static final int ISBN_LONG = 13;
    private static final int MULTIPLIER_ISBN_SHORT = 11;
    private static final int MULTIPLIER_ISBN_LONG = 10;

    public boolean checkISBN(String isbn) {
        if (isbn.length() != ISBN_SHORT && isbn.length() != ISBN_LONG) {
            throw new NumberFormatException(
                    String.format("ISBN numbers must be %d or %d digits long", ISBN_SHORT, ISBN_LONG));
        }
        return checkISBN(toArray(isbn));
    }

    private int[] toArray(String isbn) {
        int[] digits = new int[isbn.length() == ISBN_SHORT ? ISBN_SHORT : ISBN_LONG];
        for (int i = 0; i < digits.length; i++) {
            char ch = isbn.charAt(i);
            if (Character.isDigit(ch)) {
                digits[i] = Character.getNumericValue(ch);
            } else {
                if (i == digits.length - 1 && ch == 'X') {
                    digits[i] = 10;
                } else {
                    throw new NumberFormatException("ISBN number can only contain digits");
                }
            }
        }
        return digits;
    }

    private boolean checkISBN(int[] digits) {
        if (digits.length == ISBN_SHORT) {
            return checkIsbnShort(digits);
        } else if (digits.length == ISBN_LONG) {
            return checkIsbnLong(digits);
        }
        throw new IllegalStateException(
                String.format("Number of digits must be %d or %d.", ISBN_SHORT, ISBN_LONG));
    }

    private boolean checkIsbnLong(int[] digits) {
        int sum = 0;
        int t = 1;
        for (int d : digits) {
            sum += d * t;
            t = t == 1 ? 3 : 1;
        }
        return sum % MULTIPLIER_ISBN_LONG == 0;
    }

    private boolean checkIsbnShort(int[] digits) {
        int sum = 0;
        int t = digits.length;
        for (int i = 0; i < digits.length; i++, t--) {
            sum += digits[i] * t;
        }
        return sum % MULTIPLIER_ISBN_SHORT == 0;
    }
}
