package learn.hfdp.ch09iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu implements MenuComponent, Iterable<MenuComponent> {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

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
        for (MenuComponent mc : menuComponents) {
            mc.print();
        }
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        return menuComponents.iterator();
    }
}
