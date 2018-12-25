package learn.hfdp.ch04factory.franchising.chicago;

import learn.hfdp.ch04factory.Pizza;

public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        super("ChicagoStyle Veggie Pizza", "Crust", "Marinara sauce");
        addToppings(
            "Shredded mozzarella",
            "Grated parmesan",
            "Diced onion",
            "Sliced mushrooms",
            "Sliced red pepper",
            "Sliced black olives"
        );
    }
}
