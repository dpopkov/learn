package learn.hfdp.ch04factory;

public class ClamPizza extends Pizza {
    public ClamPizza() {
        super("Clam Pizza", "Thin crust", "White garlic sauce");
        addToppings("Clams", "Grated parmesan cheese");
    }
}
