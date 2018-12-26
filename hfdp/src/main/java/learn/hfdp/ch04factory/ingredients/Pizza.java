package learn.hfdp.ch04factory.ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Pizza {
    private static final String NL = System.lineSeparator();

    protected final String name;
    protected final Dough dough;
    protected final Sauce sauce;
    protected final Veggies[] veggies;
    protected final Cheese cheese;
    protected final Pepperoni pepperoni;
    protected final Clams clams;

    public Pizza(String name, Dough dough, Sauce sauce,
                 Veggies[] veggies, Cheese cheese,
                 Pepperoni pepperoni, Clams clams) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
        this.veggies = veggies;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.clams = clams;
    }

    public String getName() {
        return name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("--- ").append(name).append(" ---").append(NL);
        display.append(dough).append(NL);
        display.append(sauce).append(NL);
        display.append(Arrays.toString(veggies)).append(NL);
        display.append(cheese).append(NL);
        display.append(pepperoni).append(NL);
        display.append(clams).append(NL);
        return display.toString();
    }
}
