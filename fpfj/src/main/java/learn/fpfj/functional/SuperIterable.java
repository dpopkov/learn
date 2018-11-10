package learn.fpfj.functional;

import learn.fpfj.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
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
        self.forEach(e -> {
            if (predicate.test(e)) {
                results.add(e);
            }
        });
        return new SuperIterable<>(results);
    }

    /*public void forEvery(Consumer<E> consumer) {
        for (E e : self) {
            consumer.accept(e);
        }
    }*/

    public <R> SuperIterable<R> map(Function<E, R> operation) {
        List<R> results = new ArrayList<>();
        self.forEach(e -> results.add(operation.apply(e)));
        return new SuperIterable<>(results);
    }

    @SuppressWarnings("Convert2MethodRef")
    public static void main(String[] args) {
        SuperIterable<String> strings = new SuperIterable<>(
                Arrays.asList("LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limeGreen")
        );
        strings.forEach(s -> System.out.println("> " + s));

        SuperIterable<String> upper = strings.filter(s -> Character.isUpperCase(s.charAt(0)));
        System.out.println("------------------------");
        upper.forEach(s -> System.out.println("> " + s));

        System.out.println("------------------------");
        strings.forEach(s -> System.out.println("> " + s));

        System.out.println("------------------------");
        strings.filter(s -> Character.isUpperCase(s.charAt(0)))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        /*System.out.println("------------------------");
        strings.forEach(s -> System.out.println("> " + s));*/

        SuperIterable<Car> cars = new SuperIterable<>(
            Arrays.asList(
                Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
                Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
                Car.withGasColorPassengers(9, "Black", "Weatherwas", "Magrat"),
                Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
                Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
            )
        );
        System.out.println("------------------------");
        cars.filter(c -> c.getGasLevel() > 6)
                .map(c -> c.getPassengers().get(0) + " is driving a " + c.getColor() + " car with lots of fuel.")
                .forEach(c -> System.out.println("> " + c));
    }
}
