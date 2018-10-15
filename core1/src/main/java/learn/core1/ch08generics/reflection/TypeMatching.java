package learn.core1.ch08generics.reflection;

import learn.core1.ch04.Employee;
import learn.core1.ch08generics.Pair;

/**
 * Example of matching the type variable of a {@code Class<T>} parameter in a generic method.
 */
public class TypeMatching {
    public static <T> Pair<T> makePair(Class<T> c) throws IllegalAccessException, InstantiationException {
        return new Pair<>(c.newInstance(), c.newInstance());
    }

    public static void main(String[] args) throws Exception {
        Pair<Employee> p = makePair(Employee.class);
        System.out.println(p);
    }
}
