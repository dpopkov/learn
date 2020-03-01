package learn.hfdp.ch06command.devices;

public class GarageDoor {
    private final String location;
    private boolean up;

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        up = true;
        System.out.println(this + " is up");
    }

    public void down() {
        up = false;
        System.out.println(this + " is down");
    }

    public void stop() {
        System.out.println(this + " stopped");
    }

    public void lightOn() {
        System.out.println(this + " light is on");
    }

    public void lightOff() {
        System.out.println(this + " light is off");
    }

    public boolean isUp() {
        return up;
    }

    @Override
    public String toString() {
        return location + " garage door";
    }
}
