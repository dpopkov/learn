package learn.hfdp.ch09iterator;

public class Waitress {
    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    /** Prints every item on the menu. */
    public void printMenu() {
        allMenus.print();
    }

    /** Prints just breakfast items. */
    public void printBreakfastMenu() {

    }

    /** Prints just lunch items. */
    public void printLunchMenu() {

    }

    /** Prints all vegetarian menu items. */
    public void printVegetarianMenu() {

    }

    /**
     * Given the name of an item, returns true if the item is vegetarian,
     * otherwise, returns false.
     */
    public boolean isItemVegetarian(String name) {
        return false;
    }
}
