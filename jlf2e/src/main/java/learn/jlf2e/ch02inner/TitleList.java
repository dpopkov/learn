package learn.jlf2e.ch02inner;

import java.util.ArrayList;
import java.util.Iterator;

public class TitleList {
    private final ArrayList<String> titleList = new ArrayList<>();

    public void addTitle(String title) {
        titleList.add(title);
    }

    @SuppressWarnings("unused")
    public void removeTitle(String title) {
        titleList.remove(title);
    }

    public Iterator<String> titleIterator() {
        class TitleIterator implements Iterator<String> {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < titleList.size();
            }

            @Override
            public String next() {
                return titleList.get(count++);
            }
        }
        return new TitleIterator();
    }
}
