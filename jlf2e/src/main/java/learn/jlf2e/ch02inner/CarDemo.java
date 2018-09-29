/* 2-13. Creating objects of a member inner class. */
package learn.jlf2e.ch02inner;

public class CarDemo {
    public static void main(String[] args) {
        Car c = new Car(2018);
        Car.Tire t = c.new Tire(9);
        System.out.println("Car's year: " + c.getYear());
        System.out.println("Car's tyre radius: " + t.getRadius());
    }
}
