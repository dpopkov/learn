package learn.ooad.ch01;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private final List<Guitar> guitars;

    public Inventory() {
        this.guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, GuitarSpec spec) {
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar g : guitars) {
            if (g.getSerialNumber().equals(serialNumber)) {
                return g;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec spec) {
        List<Guitar> result = new LinkedList<>();
        for (Guitar g : guitars) {
            if (!spec.equals(g.getSpec())) {
                continue;
            }
            result.add(g);
        }
        return result;
    }
}
