package learn.hfdp.ch09iterator;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
}
