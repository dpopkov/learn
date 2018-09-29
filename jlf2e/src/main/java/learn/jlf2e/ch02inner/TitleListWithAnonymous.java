/* 2-10. The title list using an anonymous class. */
package learn.jlf2e.ch02inner;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("unused")
public class TitleListWithAnonymous {
    private final ArrayList<String> titleList = new ArrayList<>();

    public void addTitle(String title) {
        titleList.add(title);
    }

    public void removeTitle(String title) {
        titleList.remove(title);
    }

    public Iterator<String> titleIterator() {
        return new Iterator<String>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < titleList.size();
            }

            @Override
            public String next() {
                return titleList.get(count++);
            }
        };
    }
}
