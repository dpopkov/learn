package learn.hfdp.ch09iterator;

import java.io.PrintStream;
import java.util.Iterator;

public class Waitress {
    private PrintStream out;
    private MenuItemPrinter printer;
    private Menu pancakeHouseMenu;
    private Menu dinnerMenu;

    public Waitress(PrintStream out, Menu pancakeHouseMenu, Menu dinnerMenu) {
        this.out = out;
        this.printer = new MenuItemPrinter(out);
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinnerMenu = dinnerMenu;
    }

    /** Prints every item on the menu. */
    public void printMenu() {
        out.println("MENU");
        out.println("----");
        out.println("BREAKFAST");
        printMenuItems(pancakeHouseMenu.createIterator());
        out.println();
        out.println("LUNCH");
        printMenuItems(dinnerMenu.createIterator());
    }

    private void printMenuItems(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            printer.print(iterator.next());
        }
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
