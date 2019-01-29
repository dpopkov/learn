package learn.core1.ch09collections2;

import java.util.*;
import java.util.function.Function;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> a = makeList(LinkedList::new, "Amy", "Carl", "Erica");
        List<String> b = makeList(LinkedList::new, "Bob", "Doug", "Frances", "Gloria");
        merge(a, b);
        System.out.println("a = " + a);
        removeEveryNth(b, 2);
        System.out.println("b = " + b);
        a.removeAll(b);
        System.out.println("a = " + a);
    }

    @SuppressWarnings("SameParameterValue")
    private static <T> void removeEveryNth(List<T> list, int n) {
        Iterator<T> it = list.iterator();
        int skip = n - 1;
        while (it.hasNext()) {
            for (int i = 0; i < skip; i++) {
                if (it.hasNext()) {
                    it.next();
                }
            }
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    private static void merge(List<String> a, List<String> b) {
        ListIterator<String> aIt = a.listIterator();
        for (String s : b) {
            if (aIt.hasNext()) {
                aIt.next();
            }
            aIt.add(s);
        }
    }

    @SafeVarargs
    private static <T> List<T> makeList(Function<Collection<T>, List<T>> constructor, T... values) {
        return constructor.apply(Arrays.asList(values));
    }
}
