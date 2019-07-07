package introtdd.ch02testing;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class CafeTest {

    private static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    private static final int LATTE_BEANS = CoffeeType.Latte.getRequiredBeans();
    private static final int LATTE_MILK = CoffeeType.Latte.getRequiredMilk();
    private static final int NO_MILK = 0;
    private static final int NO_BEANS = 0;

    @Test
    public void canBrewEspresso() {
        /* Given: Preconditions */
        Cafe cafe = cafeWithBeans(ESPRESSO_BEANS);
        /* When: Behavior */
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        /* Then: Post-conditions */
        assertThat("Wrong type of coffee", coffee.getType(), is(CoffeeType.Espresso));
        assertThat("Wrong quantity of milk", coffee.getMilk(), is(NO_MILK));
        assertThat("Wrong quantity of beans", coffee.getBeans(), is(ESPRESSO_BEANS));
    }

    @Test
    public void canBrewLatte() {
        /* Given: Preconditions */
        Cafe cafe = cafeWithBeans(LATTE_BEANS);
        cafe.restockMilk(LATTE_MILK);
        /* When: Behavior */
        Coffee coffee = cafe.brew(CoffeeType.Latte);
        /* Then: Post-conditions */
        assertThat("Wrong type of coffee", coffee.getType(), is(CoffeeType.Latte));
        assertThat("Wrong quantity of milk", coffee.getMilk(), is(LATTE_MILK));
        assertThat("Wrong quantity of beans", coffee.getBeans(), is(LATTE_BEANS));
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // Given
        Cafe cafe = cafeWithBeans(ESPRESSO_BEANS);
        // When
        cafe.brew(CoffeeType.Espresso);
        // Then
        assertThat("Wrong quantity of beans in stock", cafe.getBeansInStock(), is(NO_BEANS));
    }

    @Test
    public void brewingLatteConsumesMilk() {
        Cafe cafe = cafeWithBeans(LATTE_BEANS);
        cafe.restockMilk(LATTE_MILK);
        cafe.brew(CoffeeType.Latte);
        assertThat("Wrong amount of milk", cafe.getMilkInStock(), is(NO_MILK));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeAmountThrowsException() {
        cafeWithBeans(-ESPRESSO_BEANS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void latteRequiresMilk() {
        Cafe cafe = cafeWithBeans(ESPRESSO_BEANS);
        cafe.restockMilk(1);
        cafe.brew(CoffeeType.Latte);
    }

    private Cafe cafeWithBeans(int beans) {
        Cafe cafe = new Cafe();
        cafe.restockBeans(beans);
        return cafe;
    }
}
