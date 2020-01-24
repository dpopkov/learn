package learn.ooad.shop;

public class Guitar extends Instrument {

    private final GuitarSpec spec;

    public Guitar(String serialNumber, double price, GuitarSpec spec) {
        super(serialNumber, price);
        this.spec = spec;
    }

    public GuitarSpec getSpec() {
        return spec;
    }
}
