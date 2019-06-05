package learn.dsajg6e.ch02oop.exer;

import learn.dsajg6e.ch02oop.exer.P0236Change.Coin;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class P0236ChangeTest {

    @Test
    public void testParse() {
        String s = "10c 20n 30d 40q 50$ 5c 1$";
        Map<Coin, Integer> result = P0236Change.parse(s);
        Map<Coin, Integer> expected = Map.of(
                Coin.CENT, 15,
                Coin.NICKEL, 20,
                Coin.DIME, 30,
                Coin.QUARTER, 40,
                Coin.DOLLAR, 51
        );
        assertThat(result, is(expected));
    }

    @Test
    public void testGenerate() {
        int sum = 5100 + 40 * 25 + 30 * 10 + 20 * 5 + 15;
        Map<Coin, Integer> result = P0236Change.generate(sum);
        Map<Coin, Integer> expected = Map.of(
                Coin.NICKEL, 1,
                Coin.DIME, 1,
                Coin.DOLLAR, 65
        );
        assertThat(result, is(expected));
    }
}