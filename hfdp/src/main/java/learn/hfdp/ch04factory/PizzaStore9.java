package learn.hfdp.ch04factory;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Version of {@code PizzaStore} that uses improvements from Java 9.
 */
public class PizzaStore9 {
    private static Map<String, Supplier<? extends Pizza>> constructors =
            Map.of("cheese", CheesePizza::new,
                    "greek", GreekPizza::new,
                    "pepperoni", PepperoniPizza::new);

    public Pizza orderPizza(String type) {
        return constructors.get(type).get();
    }
}
