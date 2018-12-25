package learn.hfdp.ch04factory.franchising.ny;

import learn.hfdp.ch04factory.Pizza;
import learn.hfdp.ch04factory.franchising.PizzaStore;

import java.util.Map;
import java.util.function.Supplier;

public class NYPizzaStore extends PizzaStore {
    private final Map<String, Supplier<Pizza>> constructors = Map.of(
            "cheese", NYStyleCheesePizza::new,
            "veggie", NYStyleVeggiePizza::new,
            "clam", NYStyleClamPizza::new,
            "pepperoni", NYStylePepperoniPizza::new
    );

    protected Pizza createPizza(String type) {
        return constructors.get(type).get();
    }

    public static void main(String[] args) {
        NYPizzaStore store = new NYPizzaStore();
        Pizza p = store.orderPizza("cheese");
        System.out.println(p);
    }
}
