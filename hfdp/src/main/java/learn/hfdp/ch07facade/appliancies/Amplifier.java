package learn.hfdp.ch07facade.appliancies;

public class Amplifier extends BaseAppliance {
    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;

    public Amplifier() {
        super("Amplifier");
    }

    public void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }

    public void setDvdPlayer(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public void setCdPlayer(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public void setVolume(int volume) {
    }
}
