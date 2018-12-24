package learn.hfdp.ch04factory;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        super("Pepperoni Pizza", "Crust", "Marinara sauce");
        addToppings("Sliced Pepperoni", "Sliced Onion", "Grated parmesan cheese");
    }
}
