package learn.hfdp.ch06command.devices;

public class GarageDoor {
    private boolean up;

    public void up() {
        up = true;
    }

    public void down() {
        up = false;
    }

    public void stop() {
    }

    public void lightOn() {
    }

    public void lightOff() {
    }

    public boolean isUp() {
        return up;
    }
}
