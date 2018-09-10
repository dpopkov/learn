package learn.hfdp.ch01;

public class RubberDuck extends Duck implements Quackable {
    @Override
    public void display() {
        System.out.println("Looks like a rubber.");
    }

    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
