package learn.ooad.ch01;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        this.guitars = new LinkedList<>();
    }

    public void addGuitar(String serialNumber, double price, String builder, String model,
                          String type, String backWood, String topWood) {
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
        String builder = searchInfo.getBuilder();
        String model = searchInfo.getModel();
        String type = searchInfo.getType();
        String backWood = searchInfo.getBackWood();
        String topWood = searchInfo.getTopWood();
        for (Guitar g : guitars) {
            if (!Objects.equals(builder, g.getBuilder())) {
                continue;
            }
            if (!Objects.equals(model, g.getModel())) {
                continue;
            }
            if (!Objects.equals(type, g.getType())) {
                continue;
            }
            if (!Objects.equals(backWood, g.getBackWood())) {
                continue;
            }
            if (!Objects.equals(topWood, g.getTopWood())) {
                continue;
            }
            return g;
        }
        return null;
    }
}
