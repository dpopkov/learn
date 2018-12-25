package learn.hfdp.ch04factory.franchising.ny;

import learn.hfdp.ch04factory.Pizza;

public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        super("NYStyle Clam Pizza", "Thin crust", "White garlic sauce");
        addToppings("Clams", "Grated parmesan cheese");
    }
}
