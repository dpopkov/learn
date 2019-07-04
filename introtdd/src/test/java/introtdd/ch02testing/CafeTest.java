package introtdd.ch02testing;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CafeTest {
    @Test
    public void canBrewEspresso() {
        /* Given: Preconditions */
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        /* When: Behavior */
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        /* Then: Post-conditions */
        assertThat(coffee.getType(), is(CoffeeType.Espresso));
        assertThat(coffee.getMilk(), is(0));
        assertThat(coffee.getBeans(), is(7));
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        // When
        cafe.brew(CoffeeType.Espresso);
        // Then
        assertThat(cafe.getBeansInStock(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeAmountThrowsException() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(-7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void latteRequiresMilk() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        cafe.restockMilk(1);
        cafe.brew(CoffeeType.Latte);
    }
}
