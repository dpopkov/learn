package learn.fpfj.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
    private Iterable<E> self;

    public SuperIterable(Iterable<E> self) {
        this.self = self;
    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }

    public SuperIterable<E> filter(Predicate<E> predicate) {
        List<E> results = new ArrayList<>();
        for(E e : self) {
            if (predicate.test(e)) {
                results.add(e);
            }
        }
        return new SuperIterable<>(results);
    }

    public static void main(String[] args) {
        SuperIterable<String> strings = new SuperIterable<>(
                Arrays.asList("LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limeGreen")
        );
        for (String s : strings) {
            System.out.println(s);
        }

        SuperIterable<String> upper = strings.filter(s -> Character.isUpperCase(s.charAt(0)));
        System.out.println("------------------------");
        for (String s : upper) {
            System.out.println(s);
        }

        System.out.println("------------------------");
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
