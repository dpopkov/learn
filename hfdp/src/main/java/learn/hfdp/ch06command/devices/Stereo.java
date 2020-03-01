package learn.hfdp.ch06command.devices;

public class Stereo {
    private final String location;
    private boolean on;

    public Stereo(String location) {
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

    public void setCd() {
        System.out.println(this + " sets CD");
    }

    public void setDvd() {
        System.out.println(this + " sets DVD");
    }

    public void setRadio() {
        System.out.println(this + " sets radio");
    }

    public void setVolume(int value) {
        System.out.println(this + " sets volume to " + value);
    }

    @Override
    public String toString() {
        return location + " stereo";
    }
}
