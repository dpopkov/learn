package learn.ooad.ch01;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        this.guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, Builder builder, String model,
                          Type type, Wood backWood, Wood topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model,
                            type, backWood, topWood);
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

    public Guitar search(Guitar searchInfo) {
        Builder builder = searchInfo.getBuilder();
        String model = searchInfo.getModel();
        Type type = searchInfo.getType();
        Wood backWood = searchInfo.getBackWood();
        Wood topWood = searchInfo.getTopWood();
        for (Guitar g : guitars) {
            if (builder != g.getBuilder()) {
                continue;
            }
            if (!Objects.equals(model, g.getModel())) {
                continue;
            }
            if (type != g.getType()) {
                continue;
            }
            if (backWood != g.getBackWood()) {
                continue;
            }
            if (topWood != g.getTopWood()) {
                continue;
            }
            return g;
        }
        return null;
    }
}
