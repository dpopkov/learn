package learn.fpfj.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    private int gasLevel;
    private String color;
    private List<String> passengers;
    private List<String> trunkContent;

    private Car(int gasLevel, String color, List<String> passengers, List<String> trunkContent) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContent = trunkContent;
    }

    public static Car withGasColorPassengers(int gasLevel, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        return new Car(gasLevel, color, p, null);
    }

    public static Car withGasColorPassengersAndTrunk(int gasLevel, String color, String... passengers) {
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        return new Car(gasLevel, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public String getColor() {
        return color;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getTrunkContent() {
        return trunkContent;
    }

    @Override
    public String toString() {
        return "Car{" +
                "gasLevel=" + gasLevel +
                ", color='" + color + '\'' +
                ", passengers=" + passengers +
                (trunkContent != null ? ", trunkContent=" + trunkContent : " no trunk") + '}';
    }

    public static CarCriterion getRedCarCriterion() {
        return RED_CAR_CRITERION;
    }

    private static final CarCriterion RED_CAR_CRITERION = (c) -> {
        return c.getColor().equals("Red");
    };

    public static CarCriterion getCarLevelCarCriterion(int threshold) {
        return new GasLevelCarCriterion(threshold);
    }

    private static class GasLevelCarCriterion implements CarCriterion {
        private int threshold;

        public GasLevelCarCriterion(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public boolean test(Car c) {
            return c.getGasLevel() >= threshold;
        }
    }

    public static Comparator<Car> getGasComparator() {
        return gasComparator;
    }

    private static final Comparator<Car> gasComparator = (Car o1, Car o2) -> {
        return o1.gasLevel - o2.gasLevel;
    };
}
