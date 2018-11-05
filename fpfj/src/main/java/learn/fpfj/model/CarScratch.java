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

        cars.sort(new PassengerCountOrder());
        showAll(cars);

        cars.sort(Car.getGasComparator());
        showAll(cars);

        showAll(getByCriterion(cars, c -> c.getPassengers().size() == 2));
        showAll(getByCriterion(cars, Car.getFourPassengerCriterion()));

        /* Making context for lambda using cast to functional interface. */
        boolean b = ((Criterion<Car>)(c -> c.getColor().equals("Red"))).test(cars.get(0));
        System.out.println("0th car is red = " + b);
        /* Cast to other functional interface changes the type of lambda. */
        boolean b2 = ((Strange)(c -> c.getColor().equals("Red"))).stuff(cars.get(0));
        System.out.println("0th car is still red = " + b2);

        List<String> colors = Arrays.asList("LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen");
        showAll(getByCriterion(colors, st -> st.length() > 4));
        showAll(getByCriterion(colors, st -> Character.isUpperCase(st.charAt(0))));

        LocalDate today = LocalDate.now();
        List<LocalDate> dates = Arrays.asList(today, today.plusDays(1), today.plusDays(7),
                today.minusDays(1)
        );
        showAll(getByCriterion(dates, d -> d.isAfter(today)));
    }
}
