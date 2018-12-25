package learn.hfdp.ch04factory.franchising.chicago;

import learn.hfdp.ch04factory.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        super("ChicagoStyle Cheese Pizza", "Regular Crust", "Marinara Pizza Sauce");
        addToppings("Fresh Mozzarella", "Parmesan");
    }
}
