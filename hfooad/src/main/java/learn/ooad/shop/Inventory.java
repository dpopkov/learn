package learn.ooad.shop;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private final List<Instrument> instruments;

    public Inventory() {
        this.instruments = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        instruments.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Instrument g : instruments) {
            if (g.getSerialNumber().equals(serialNumber)) {
                return g;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec spec) {
        List<Instrument> result = new LinkedList<>();
        for (Instrument g : instruments) {
            if (spec.matches(g.getSpec())) {
                result.add(g);
            }
        }
        return result;
    }
}
