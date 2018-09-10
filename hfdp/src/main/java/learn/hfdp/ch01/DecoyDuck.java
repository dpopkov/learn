package learn.hfdp.ch01;

public class DecoyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("Looks like decoy.");
    }

    @Override
    public void quack() {
        // does nothing
    }

    @Override
    public void fly() {
        // does nothing
    }
}
