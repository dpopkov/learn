package learn.hfdp.ch06command.devices;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private final String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void high() {
        System.out.println(this + " is on high");
        speed = HIGH;
    }

    public void medium() {
        System.out.println(this + " is on medium");
        speed = MEDIUM;
    }

    public void low() {
        System.out.println(this + " is on low");
        speed = LOW;
    }

    public void off() {
        System.out.println(this + " is off");
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (OFF <= speed && speed <= HIGH) {
            this.speed = speed;
            System.out.println(this + " set speed to " + speed);
        }
    }

    @Override
    public String toString() {
        return location + " ceiling fan";
    }
}
