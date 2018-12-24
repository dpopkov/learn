package learn.hfdp.ch04factory;

public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super("Veggie Pizza", "Crust", "Marinara sauce");
        addToppings(
            "Shredded mozzarella",
            "Grated parmesan",
            "Diced onion",
            "Sliced mushrooms",
            "Sliced red pepper",
            "Sliced black olives"
        );
    }
}
