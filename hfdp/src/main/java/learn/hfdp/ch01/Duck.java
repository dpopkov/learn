package learn.hfdp.ch01;

public abstract class Duck {
    public void quack() {
        System.out.println("Quack!");
    }

    public void swim() {
        System.out.println("Swim");
    }

    public abstract void display();
}
