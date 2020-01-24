package learn.ooad.shop;

public abstract class Instrument {
    private final String serialNumber;
    private double price;
    protected InstrumentSpec spec;

    public Instrument(String serialNumber, double price) {
        this.serialNumber = serialNumber;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }
}
