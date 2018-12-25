package learn.hfdp.ch04factory.franchising.chicago;

import learn.hfdp.ch04factory.Pizza;

public class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        super("ChicagoStyle Clam Pizza", "Thin crust", "White garlic sauce");
        addToppings("Clams", "Grated parmesan cheese");
    }
}
