package learn.core1.ch08generics.reflection;

import learn.core1.ch04.Employee;
import learn.core1.ch08generics.Pair;

import java.lang.reflect.InvocationTargetException;

/**
 * Example of matching the type variable of a {@code Class<T>} parameter in a generic method.
 */
public class TypeMatching {
    public static <T> Pair<T> makePair(Class<T> c) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return new Pair<>(c.getDeclaredConstructor().newInstance(),
                c.getDeclaredConstructor().newInstance());
    }

    public static void main(String[] args) throws Exception {
        Pair<Employee> p = makePair(Employee.class);
        System.out.println(p);
    }
}
