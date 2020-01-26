package learn.ooad.shop;

public class Instrument {
    private final String serialNumber;
    private final double price;
    private final InstrumentSpec spec;

    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }
}
