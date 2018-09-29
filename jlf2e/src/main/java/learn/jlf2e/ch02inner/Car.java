package learn.jlf2e.ch02inner;

public class Car {
    private final int year;

    public class Tire {
        private final double radius;

        public Tire(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @SuppressWarnings("unused")
        public Car getCar() {
            return Car.this;
        }
    }

    public Car(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
