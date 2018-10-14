package learn.core1.ch08generics.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * Examples how to create generic arrays.
 */
public class ConstructGenArr {
    public static void main(String[] args) {
        // 1)
        whenUsedAsPrivateField();

        // 2)
        whenReturningArray();

        // 3)
        whenUsingReflection();
    }

    private static void whenUsingReflection() {
        class Foo {
            @SuppressWarnings("unchecked")
            <T extends Comparable<T>> T[] minMax(T... a) {
                T[] mm = (T[]) Array.newInstance(a.getClass().getComponentType(), 2);
                mm[0] = a[0];
                mm[1] = a[0];
                return mm;
            }
        }

        Bar<String>[] bars = array(new Bar<>("one"), new Bar<>("two"), new Bar<>("three"));
        System.out.println(Arrays.toString(bars));
        Bar<String>[] bars2 = new Foo().minMax(bars);
        System.out.println(Arrays.toString(bars2));
    }

    private static void whenReturningArray() {
        class Foo {
            @SuppressWarnings("unused")
            <T extends Comparable<T>> T[] minMaxWithException(T... a) {
                Object[] mm = new Object[2];
                mm[0] = a[0];
                mm[1] = a[0];
                return (T[]) mm; // ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Comparable;
            }

            <T extends Comparable<T>> T[] minMax(IntFunction<T[]> constr, T... a) {
                T[] mm = constr.apply(2);
                mm[0] = a[0];
                mm[1] = a[0];
                return mm;
            }
        }

        Bar<String>[] bars = array(new Bar<>("one"), new Bar<>("two"), new Bar<>("three"));
        System.out.println(Arrays.toString(bars));
        @SuppressWarnings("unchecked")
        Bar<String>[] bars2 = new Foo().minMax(Bar[]::new, bars);
        System.out.println(Arrays.toString(bars2));
    }

    private static void whenUsedAsPrivateField() {
        class GenListCastWhenRetrieve<E> {
            private final Object[] elements = new Object[10];

            public void set(int index, E e) {
                elements[index] = e;
            }

            @SuppressWarnings("unchecked")
            public E get(int index) {
                return (E) elements[index];
            }
        }

        class GenListCastWhenInit<E> {
            @SuppressWarnings("unchecked")
            private final E[] elements = (E[]) new Object[10];

            public void set(int index, E e) {
                elements[index] = e;
            }

            public E get(int index) {
                return elements[index];
            }
        }

        GenListCastWhenRetrieve<String> list = new GenListCastWhenRetrieve<>();
        list.set(0, "First");
        System.out.println(list.get(0));

        GenListCastWhenInit<String> list2 = new GenListCastWhenInit<>();
        list2.set(0, "Second");
        System.out.println(list2.get(0));
    }

    @SafeVarargs
    private static <T> T[] array(T...ta) { return ta; }
}

class Bar<T extends Comparable<T>> implements Comparable<Bar<T>> {
    private final T value;

    public Bar(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + value + ")";
    }

    @Override
    public int compareTo(Bar<T> o) {
        return value.compareTo(o.value);
    }
}
