package learn.ptddjp.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkValidISBN10digits() {
        ValidateISBN validator = new ValidateISBN();
        boolean result;
        result = validator.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void checkValidISBN13digits() {
        ValidateISBN validator = new ValidateISBN();
        boolean result;
        result = validator.checkISBN("9780135166307");
        assertTrue("first value", result);
        result = validator.checkISBN("9781853260087");
        assertTrue("second value", result);
    }

    @Test
    public void isbnNumbers10digitsEndingInAnXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkInvalidISBN13digits() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260088");
        assertFalse(result);
    }

    @Test
    public void checkInvalidISBN10digits() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitsIsbnAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericIsbn10digitsIsNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }
}
