package learn.hfdp.ch06command.devices;

public class Light {
    private boolean on;

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
