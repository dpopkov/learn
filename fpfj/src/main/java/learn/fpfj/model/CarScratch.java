package learn.fpfj.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class CarScratch {
    public static <T> ToIntFunction<T> compareWithThis(T target, Comparator<T> comp) {
        return x -> comp.compare(x, target);
    }

    public static <T> Predicate<T> comparesGreater(ToIntFunction<T> func) {
        return x -> func.applyAsInt(x) > 0;
    }

    public static <T> void showAll(List<T> lc) {
        for (T c : lc) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------------- ");
    }

    public static <T> List<T> getByCriterion(Iterable<T> in, Predicate<T> predicate) {
        List<T> output = new ArrayList<>();
        for (T c : in) {
            if (predicate.test(c)) {
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
        showAll(getByCriterion(cars, Car.getRedCarPredicate()));
        showAll(getByCriterion(cars, Car.getGasLevelCarCriterion(6)));

        Predicate<Car> level7 = Car.getGasLevelCarCriterion(7);
        showAll(getByCriterion(cars, level7));
        Predicate<Car> notLevel7 = level7.negate();
        showAll(getByCriterion(cars, notLevel7));

        Predicate<Car> isRed = Car.getColorCriterion("Red");
        Predicate<Car> fourPassengers = Car.getFourPassengerCriterion();
        Predicate<Car> redFourPassengers = isRed.and(fourPassengers);
        showAll(getByCriterion(cars, redFourPassengers));

        Predicate<Car> isBlack = Car.getColorCriterion("Black");
        Predicate<Car> blackOrFourPassengers = isBlack.or(fourPassengers);
        showAll(getByCriterion(cars, blackOrFourPassengers));

        Car bert = Car.withGasColorPassengers(5, "", "");
        ToIntFunction<Car> compareWithBert = compareWithThis(bert, Car.getGasComparator());

        System.out.println();
        cars.forEach(car -> System.out.printf("Comparing %s with bert gives %s%n", car,
                compareWithBert.applyAsInt(car)));

        System.out.println();
        Predicate<Car> greaterThanBert = comparesGreater(compareWithBert);
        cars.forEach(car -> System.out.printf("%s is %s than bert%n", car,
                greaterThanBert.test(car) ? "more" : "less"));

        System.out.println();
        showAll(getByCriterion(cars, greaterThanBert));
    }
}
