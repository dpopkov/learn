package learn.hfdp.ch09iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu implements MenuComponent, Iterable<MenuComponent> {
    private final List<MenuComponent> menuComponents = new ArrayList<>();
    private final String name;
    private final String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println(getName() + ", " + getDescription());
        System.out.println("---------------------------------");
    }

    @Override
    public boolean isVegetarian() {
        return true;
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        return menuComponents.iterator();
    }
}
