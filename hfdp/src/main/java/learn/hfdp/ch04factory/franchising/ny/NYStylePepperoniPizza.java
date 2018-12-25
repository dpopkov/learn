package learn.hfdp.ch04factory.franchising.ny;

import learn.hfdp.ch04factory.Pizza;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        super("NYStyle Pepperoni Pizza", "Crust", "Marinara sauce");
        addToppings("Sliced Pepperoni", "Sliced Onion", "Grated parmesan cheese");
    }
}
