package learn.hfdp.ch06command.devices;

public class TV {
    private final String location;
    private boolean on;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        on = true;
        System.out.println(this + " is on");
    }

    public void off() {
        on = false;
        System.out.println(this + " is off");
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return location + " TV";
    }
}
