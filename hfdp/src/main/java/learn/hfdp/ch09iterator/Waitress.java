package learn.hfdp.ch09iterator;

import java.util.List;

public class Waitress {
    private final MenuComponent allMenus;

    public Waitress(Menu allMenus) {
        this.allMenus = allMenus;
    }

    /** Prints every item on the menu. */
    public void printMenu() {
        CompositeIterator iterator = new CompositeIterator(List.of(allMenus).iterator());
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

    /** Prints just breakfast items. */
    public void printBreakfastMenu() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Prints just lunch items. */
    public void printLunchMenu() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Prints all vegetarian menu items. */
    public void printVegetarianMenu() {
        CompositeIterator iterator = new CompositeIterator(List.of(allMenus).iterator());
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent.isVegetarian()) {
                menuComponent.print();
            }
        }
    }

    /**
     * Given the name of an item, returns true if the item is vegetarian,
     * otherwise, returns false.
     */
    public boolean isItemVegetarian(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
