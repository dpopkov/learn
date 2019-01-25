package learn.core1.ch08generics.reflection2;

import learn.core1.ch04.Employee;
import learn.core1.ch08generics.Pair;

import java.util.Random;

/**
 * Example that shows matching the type variable of a {@code Class<T>} parameter in
 * a generic method.
 */
public class C080902TypeMatching {
    /**
     * Makes a pair of two default instances of the specified class.
     * @param c class object that is used to create default instances
     * @param <T> type of paired elements
     * @return pair of objects
     */
    static <T> Pair<T> makePair(Class<T> c) throws ReflectiveOperationException {
        return new Pair<>(c.newInstance(), c.newInstance());
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Pair<Employee> pair = makePair(Employee.class);
        System.out.println("pair = " + pair);
        Pair<Foo> fooPair = makePair(Foo.class);
        System.out.println("fooPair = " + fooPair);
    }

    static class Foo {
        String id;

        Foo() {
            id = Integer.toString(new Random().nextInt(100));
        }

        @Override
        public String toString() {
            return "Foo{id='" + id + "'}";
        }
    }
}
