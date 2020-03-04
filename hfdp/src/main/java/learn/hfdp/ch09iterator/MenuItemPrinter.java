package learn.hfdp.ch09iterator;

import java.io.PrintStream;

public class MenuItemPrinter {
    private PrintStream out;

    public MenuItemPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(MenuItem item) {
        String text = item.getName() + " " + item.getPrice() + " -- " + item.getDescription();
        out.println(text);
    }
}
