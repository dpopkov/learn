package learn.hfdp.ch06command.devices;

public class Light {
    private final String location;
    private boolean on;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        on = true;
        System.out.println(this + " is On");
    }

    public void off() {
        on = false;
        System.out.println(this + " is Off");
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return location + " light";
    }
}
