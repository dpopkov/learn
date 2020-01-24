package learn.ooad.shop;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private final List<Instrument> instruments;

    public Inventory() {
        this.instruments = new LinkedList<>();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument;
        if (spec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) spec);
        } else if (spec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) spec);
        } else {
            throw new IllegalArgumentException("Don't know how to use this spec: " + spec);
        }
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

    public List<Guitar> search(GuitarSpec spec) {
        List<Guitar> result = new LinkedList<>();
        for (Instrument g : instruments) {
            if ((g instanceof Guitar) && spec.equals(g.getSpec())) {
                result.add((Guitar) g);
            }
        }
        return result;
    }

    public List<Mandolin> search(MandolinSpec spec) {
        List<Mandolin> result = new LinkedList<>();
        for (Instrument g : instruments) {
            if ((g instanceof Mandolin) && spec.equals(g.getSpec())) {
                result.add((Mandolin) g);
            }
        }
        return result;
    }
}
