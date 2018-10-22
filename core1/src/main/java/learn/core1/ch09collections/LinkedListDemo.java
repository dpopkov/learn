/* 9.1 */
package learn.core1.ch09collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        /* Merge words from b into a */
        ListIterator<String> aIt = a.listIterator();
        Iterator<String> bIt = b.iterator();
        while (bIt.hasNext()) {
            if (aIt.hasNext()) {
                aIt.next();
            }
            aIt.add(bIt.next());
        }
        System.out.println(a);

        /* Remove every second word from b */
        bIt = b.iterator();
        while (bIt.hasNext()) {
            bIt.next();
            if (bIt.hasNext()) {
                bIt.next();
                bIt.remove();
            }
        }
        System.out.println(b);

        /* Bulk operation: remove all words in b from a. */
        a.removeAll(b);
        System.out.println(a);
    }
}
