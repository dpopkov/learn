package learn.jlf2e.ch02inner;

import java.util.Iterator;

public class TitleListDemo {
    public static void main(String[] args) {
        TitleList titles = new TitleList();
        titles.addTitle("Java 9 Revealed");
        titles.addTitle("Beginning Java 9");
        titles.addTitle("Learn JavaFX 9");

        Iterator<String> iterator = titles.titleIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
