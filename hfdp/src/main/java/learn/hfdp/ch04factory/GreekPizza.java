package learn.hfdp.ch04factory;

public class GreekPizza extends Pizza {
    public GreekPizza() {
        name = "Greek Pizza";
        dough = "Crust";
        sauce = "Tomato sauce";
        toppings.add("Oregano");
        toppings.add("Blend of mozzarella and cheddar");
    }
}
