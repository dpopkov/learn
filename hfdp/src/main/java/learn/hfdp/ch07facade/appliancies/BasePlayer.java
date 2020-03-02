package learn.hfdp.ch07facade.appliancies;

public abstract class BasePlayer extends BaseAppliance {
    protected Amplifier amplifier;

    public BasePlayer(String name) {
        super(name);
    }

    public void setAmplifier(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    public void eject() {
        System.out.println(name + " ejects");
    }

    public void pause() {
        System.out.println(name + " pauses");
    }

    public void play() {
        System.out.println(name + " plays");
    }

    public void play(String media) {
        System.out.println(name + " plays " + media);
    }

    public void stop() {
        System.out.println(name + " stops");
    }
}
