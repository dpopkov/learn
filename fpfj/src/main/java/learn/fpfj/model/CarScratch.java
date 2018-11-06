package learn.fpfj.model;

import java.time.LocalDate;
import java.util.*;

class PassengerCountOrder implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPassengers().size() - o2.getPassengers().size();
    }
}

@FunctionalInterface
interface Criterion<E> {
    boolean test(E e);
}

interface Strange {
    boolean stuff(Car c);
}

public class CarScratch {
    public static <T> void showAll(List<T> lc) {
        for (T c : lc) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------------- ");
    }

    public static <T> List<T> getByCriterion(Iterable<T> in, Criterion<T> criterion) {
        List<T> output = new ArrayList<>();
        for (T c : in) {
            if (criterion.test(c)) {
                output.add(c);
            }
        }
        return output;
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
                Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridcully"),
                Car.withGasColorPassengers(9, "Black", "Weatherwas", "Magrat"),
                Car.withGasColorPassengers(7, "Green", "Valentine", "Gillian", "Anne", "Dr. Mahmoud"),
                Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
        );
        showAll(cars);
        showAll(getByCriterion(cars, Car.getRedCarCriterion()));
        showAll(getByCriterion(cars, Car.getGasLevelCarCriterion(6)));

        showAll(getByCriterion(cars, Car.getGasLevelCarCriterion(7)));
        showAll(getByCriterion(cars, Car.getGasLevelCarCriterion(4)));

        showAll(getByCriterion(cars, Car.getColorCriterion("Green", "Red")));
    }
}
