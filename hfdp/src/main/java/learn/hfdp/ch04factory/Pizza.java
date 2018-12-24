package learn.hfdp.ch04factory;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Pizza {
    private static final String NL = System.lineSeparator();

    protected String name;
    protected String dough;
    protected String sauce;
    protected final ArrayList<String> toppings = new ArrayList<>();

    public Pizza(String name, String dough, String sauce) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
    }

    protected void addToppings(String... toppings) {
        Collections.addAll(this.toppings, toppings);
    }

    public String getName() {
        return name;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Boxing " + name);
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ----").append(NL);
        display.append(dough).append(NL);
        display.append(sauce).append(NL);
        for (String topping : toppings) {
            display.append(topping).append(NL);
        }
        return display.toString();
    }
}
