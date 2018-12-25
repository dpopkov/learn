package learn.hfdp.ch04factory.franchising.chicago;

import learn.hfdp.ch04factory.Pizza;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        super("ChicagoStyle Pepperoni Pizza", "Crust", "Marinara sauce");
        addToppings("Sliced Pepperoni", "Sliced Onion", "Grated parmesan cheese");
    }
}
