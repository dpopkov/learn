package learn.fpfj.model;

import java.util.Arrays;
import java.util.Collections;
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

    static class RedCarCriterion implements CarCriterion {
        @Override
        public boolean test(Car c) {
            return c.getColor().equals("Red");
        }
    }

    static class GasLevelCarCriterion implements CarCriterion {
        private int threshold;

        public GasLevelCarCriterion(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public boolean test(Car c) {
            return c.getGasLevel() >= threshold;
        }
    }
}
