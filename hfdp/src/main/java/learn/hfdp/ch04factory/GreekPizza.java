package learn.hfdp.ch04factory;

public class GreekPizza extends Pizza {
    public GreekPizza() {
        super("Greek Pizza", "Crust", "Tomato sauce");
        addToppings("Oregano", "Blend of mozzarella and cheddar");
    }
}
