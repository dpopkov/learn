package learn.ijpds2nd.ch06methods.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class E0631CreditCardNumberValidatorTest {

    private final E0631CreditCardNumberValidator validator = new E0631CreditCardNumberValidator();

    @Test
    public void testIsValid() {
        long ccn = 4388576018410707L;
        boolean rst = validator.isValid(ccn);
        assertTrue(rst);
    }

    @Test
    public void testIsNotValid() {
        long ccn = 4388576018402626L;
        boolean rst = validator.isValid(ccn);
        assertFalse(rst);
    }

    @Test
    public void canAddDoubledDigitsInEvenPlacesRightToLeft() {
        long ccp = 4388576018402626L;
        int sum = validator.sumOfDoubledDigitsAtEvenPlace(ccp);
        assertEquals(37L, sum);
    }

    @Test
    public void canAddDigitsInOddPlacesRightToLeft() {
        long ccp = 4388576018402626L;
        int sum = validator.sumOfOddPlaceDigits(ccp);
        assertEquals(38L, sum);
    }

    @Test
    public void canGetOneDigitFromNumber() {
        assertEquals(4, validator.getDigit(4));
        assertEquals(7, validator.getDigit(16));
    }
}

