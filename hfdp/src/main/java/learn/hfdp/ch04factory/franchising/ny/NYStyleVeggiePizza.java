package learn.hfdp.ch04factory.franchising.ny;

import learn.hfdp.ch04factory.Pizza;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        super("NYStyle Veggie Pizza", "Crust", "Marinara sauce");
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
