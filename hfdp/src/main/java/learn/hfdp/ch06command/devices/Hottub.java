package learn.hfdp.ch06command.devices;

public class Hottub {
    private boolean jetsOn;

    public void circulate() {
        System.out.println(this + " is circulating");
    }

    public void jetsOn() {
        jetsOn = true;
        System.out.println(this + " has jets on");
    }

    public void jestOff() {
        jetsOn = false;
        System.out.println(this + " has jets off");
    }

    public void setTemperature(int temperature) {
        System.out.println(this + " has temperature set to " + temperature);
    }

    @Override
    public String toString() {
        return "Hottub";
    }

    public boolean jestAreOn() {
        return jetsOn;
    }
}
