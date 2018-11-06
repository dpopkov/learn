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

    public static Criterion<Car> getFourPassengerCriterion() {
        return c -> c.getPassengers().size() == 4;
    }

    public static Criterion<Car> getRedCarCriterion() {
        return RED_CAR_CRITERION;
    }

    private static final Criterion<Car> RED_CAR_CRITERION = c -> c.getColor().equals("Red");

    public static Criterion<Car> getGasLevelCarCriterion(int threshold) {
        return car -> car.getGasLevel() >= threshold;
    }

    public static Comparator<Car> getGasComparator() {
        return gasComparator;
    }

    private static final Comparator<Car> gasComparator = (o1, o2) -> o1.gasLevel - o2.gasLevel;
}
