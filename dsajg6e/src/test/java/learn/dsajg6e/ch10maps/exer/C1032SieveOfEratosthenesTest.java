package learn.dsajg6e.ch10maps.exer;

import org.junit.Test;

import static org.junit.Assert.*;

public class C1032SieveOfEratosthenesTest {

    @Test
    public void testPrimesTo10() {
        int[] actual = new C1032SieveOfEratosthenes().primes(10);
        int[] expected = {2, 3, 5, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPrimesFrom40To50() {
        int[] actual = new C1032SieveOfEratosthenes().primes(40, 50);
        int[] expected = {41, 43, 47};
        assertArrayEquals(expected, actual);
    }
}
