package learn.hfdp.ch04factory.franchising.chicago;

import learn.hfdp.ch04factory.Pizza;
import learn.hfdp.ch04factory.franchising.PizzaStore;

import java.util.Map;
import java.util.function.Supplier;

public class ChicagoPizzaStore extends PizzaStore {
    private final Map<String, Supplier<Pizza>> constructors = Map.of(
            "cheese", ChicagoStyleCheesePizza::new,
            "veggie", ChicagoStyleVeggiePizza::new,
            "clam", ChicagoStyleClamPizza::new,
            "pepperoni", ChicagoStylePepperoniPizza::new
    );

    protected Pizza createPizza(String type) {
        return constructors.get(type).get();
    }

    public static void main(String[] args) {
        ChicagoPizzaStore store = new ChicagoPizzaStore();
        Pizza p = store.orderPizza("cheese");
        System.out.println(p);
    }
}
