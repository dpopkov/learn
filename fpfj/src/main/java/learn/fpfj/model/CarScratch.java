package learn.fpfj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class PassengerCountOrder implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPassengers().size() - o2.getPassengers().size();
    }
}

@FunctionalInterface
interface CarCriterion {
    boolean test(Car c);
}

interface Strange {
    boolean stuff(Car c);
}

public class CarScratch {
    public static void showAll(List<Car> lc) {
        for (Car c : lc) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------------- ");
    }

    public static List<Car> getCarsByCriterion(Iterable<Car> in, CarCriterion criterion) {
        List<Car> output = new ArrayList<>();
        for (Car c : in) {
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
        showAll(getCarsByCriterion(cars, Car.getRedCarCriterion()));
        showAll(getCarsByCriterion(cars, Car.getGasLevelCarCriterion(6)));

        cars.sort(new PassengerCountOrder());
        showAll(cars);

        cars.sort(Car.getGasComparator());
        showAll(cars);

        showAll(getCarsByCriterion(cars, c -> c.getPassengers().size() == 2));
        showAll(getCarsByCriterion(cars, Car.getFourPassengerCriterion()));

        /* Making context for lambda using cast to functional interface. */
        boolean b = ((CarCriterion)(c -> c.getColor().equals("Red"))).test(cars.get(0));
        System.out.println("0th car is red = " + b);
        /* Cast to other functional interface changes the type of lambda. */
        boolean b2 = ((Strange)(c -> c.getColor().equals("Red"))).stuff(cars.get(0));
        System.out.println("0th car is still red = " + b2);
    }
}
