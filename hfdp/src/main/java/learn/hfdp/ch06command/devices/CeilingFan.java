package learn.hfdp.ch06command.devices;

public class CeilingFan {
    private final String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void high() {
        System.out.println(this + " is on high");
        speed = 3;
    }

    public void medium() {
        System.out.println(this + " is on medium");
        speed = 2;
    }

    public void low() {
        System.out.println(this + " is on low");
        speed = 1;
    }

    public void off() {
        System.out.println(this + " is off");
        speed = 0;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return location + " ceiling fan";
    }
}
