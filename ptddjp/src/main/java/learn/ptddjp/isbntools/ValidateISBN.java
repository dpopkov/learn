package learn.ptddjp.isbntools;

public class ValidateISBN {
    private static final int ISBN_LENGTH = 10;

    public boolean checkISBN(String isbn) {
        if (isbn.length() != ISBN_LENGTH) {
            throw new NumberFormatException(String.format("ISBN numbers must be %d digits long", ISBN_LENGTH));
        }
        return checkISBN(toArray(isbn));
    }

    private int[] toArray(String isbn) {
        int[] digits = new int[ISBN_LENGTH];
        for (int i = 9; i >= 0; i--) {
            char ch = isbn.charAt(i);
            if (Character.isDigit(ch)) {
                digits[i] = Character.getNumericValue(ch);
            } else {
                if (i == ISBN_LENGTH - 1 && ch == 'X') {
                    digits[i] = 10;
                } else {
                    throw new NumberFormatException("ISBN number can only contain digits");
                }
            }
        }
        return digits;
    }

    private boolean checkISBN(int[] digits) {
        int sum = 0, t = ISBN_LENGTH;
        for (int i = 0; i < ISBN_LENGTH; i++, t--) {
            sum += digits[i] * t;
        }
        return sum % 11 == 0;
    }
}
