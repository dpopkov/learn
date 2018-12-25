package learn.hfdp.ch04factory.franchising.ny;

import learn.hfdp.ch04factory.Pizza;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        super("NYStyle Cheese Pizza", "Regular Crust", "Marinara Pizza Sauce");
        addToppings("Fresh Mozzarella", "Parmesan");
    }
}
