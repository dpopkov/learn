package learn.ijpds2nd.ch06methods.exer;

public class E0631CreditCardNumberValidator {
    public boolean isValid(long number) {
        int sum = sumOfDoubledDigitsAtEvenPlace(number) + sumOfOddPlaceDigits(number);
        return sum % 10 == 0;
    }

    /** Adds all digits in the even places from right to left. */
    int sumOfDoubledDigitsAtEvenPlace(long number) {
        int sum = 0;
        while (number != 0) {
            int d = (int) (number / 10 % 10);
            sum += getDigit(d * 2);
            number /= 100;
        }
        return sum;
    }

    /** Adds all digits in the odd places from right to left. */
    int sumOfOddPlaceDigits(long number) {
        int sum = 0;
        while (number != 0) {
            sum += (int) (number % 10);
            number /= 100;
        }
        return sum;
    }

    /** Returns this number or the sum of the two digits. */
    int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }
}
