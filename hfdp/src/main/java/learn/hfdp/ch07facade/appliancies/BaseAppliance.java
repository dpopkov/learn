package learn.hfdp.ch07facade.appliancies;

public abstract class BaseAppliance {
    protected String name;

    public BaseAppliance(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " is on");
    }

    public void off() {
        System.out.println(name + " is off");
    }
}
