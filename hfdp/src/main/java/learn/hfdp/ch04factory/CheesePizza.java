package learn.hfdp.ch04factory;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        super("Cheese Pizza", "Regular Crust", "Marinara Pizza Sauce");
        addToppings("Fresh Mozzarella", "Parmesan");
    }
}
