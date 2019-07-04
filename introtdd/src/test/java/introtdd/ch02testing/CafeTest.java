package introtdd.ch02testing;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CafeTest {

    public static final int ESPRESSO_BEANS = 7;

    @Test
    public void canBrewEspresso() {
        /* Given: Preconditions */
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        /* When: Behavior */
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        /* Then: Post-conditions */
        assertThat("Wrong type of coffee", coffee.getType(), is(CoffeeType.Espresso));
        assertThat("Wrong quantity of milk", coffee.getMilk(), is(0));
        assertThat("Wrong quantity of beans", coffee.getBeans(), is(ESPRESSO_BEANS));
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        // When
        cafe.brew(CoffeeType.Espresso);
        // Then
        assertThat("Wrong quantity of beans in stock", cafe.getBeansInStock(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeAmountThrowsException() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(-ESPRESSO_BEANS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void latteRequiresMilk() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        cafe.restockMilk(1);
        cafe.brew(CoffeeType.Latte);
    }
}
