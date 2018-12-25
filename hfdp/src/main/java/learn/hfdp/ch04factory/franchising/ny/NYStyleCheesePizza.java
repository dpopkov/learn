package learn.hfdp.ch04factory.franchising.ny;

import learn.hfdp.ch04factory.Pizza;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        super("NY Style Cheese Pizza", "Thin Crust Dough", "Marinara Sauce");
        addToppings("Grated Reggiano Cheese");
    }
}
