package learn.fpfj.model;

import java.util.*;

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

        Criterion<Car> level7 = Car.getGasLevelCarCriterion(7);
        showAll(getByCriterion(cars, level7));
        Criterion<Car> notLevel7 = level7.negate();
        showAll(getByCriterion(cars, notLevel7));

        Criterion<Car> isRed = Car.getColorCriterion("Red");
        Criterion<Car> fourPassengers = Car.getFourPassengerCriterion();
        Criterion<Car> redFourPassengers = isRed.and(fourPassengers);
        showAll(getByCriterion(cars, redFourPassengers));

        Criterion<Car> isBlack = Car.getColorCriterion("Black");
        Criterion<Car> blackOrFourPassengers = isBlack.or(fourPassengers);
        showAll(getByCriterion(cars, blackOrFourPassengers));
    }
}
