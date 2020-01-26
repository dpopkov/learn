package learn.ooad.shop;

import java.util.List;
import java.util.Map;

public class FindGuitarTester {

    public static void main(String[] args) {
        Inventory inventory = setUpInventory();

        InstrumentSpec clientSpec = new InstrumentSpec();
        clientSpec.setProperty("instrumentType", InstrumentType.GUITAR);
        clientSpec.setProperty("builder", Builder.FENDER);
        clientSpec.setProperty("model", "Stratocastor");
        clientSpec.setProperty("type", Type.ELECTRIC);
        clientSpec.setProperty("numStrings", 6);
        clientSpec.setProperty("backWood", Wood.ALDER);
        clientSpec.setProperty("topWood", Wood.ALDER);
        List<Instrument> matching = inventory.search(clientSpec);
        printMatching(matching);

        System.out.println("\nNow search for GIBSON with MAPLE:");
        clientSpec = new InstrumentSpec();
        clientSpec.setProperty("builder", Builder.GIBSON);
        clientSpec.setProperty("backWood", Wood.MAPLE);
        matching = inventory.search(clientSpec);
        printMatching(matching);
    }

    private static void printMatching(List<Instrument> matching) {
        if (!matching.isEmpty()) {
            System.out.println("Erin, you might like these instruments:\n");
            for (Instrument guitar : matching) {
                InstrumentSpec spec = guitar.getSpec();
                System.out.println("We have a " + spec.getProperty("instrumentType") + " with the following properties:");
                spec.getProperties().forEach((k, v) -> {
                    if (!"instrumentType".equals(k)) {
                        System.out.println("    " + k + ": " + v);
                    }
                });
                System.out.println("\nYou can have it for only $" + guitar.getPrice() + "!\n----");
            }
        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    private static Inventory setUpInventory() {
        Inventory inventory = new Inventory();
        inventory.addInstrument("11277", 3999.95,
                makeGuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6, Wood.INDIAN_ROSEWOOD, Wood.SITKA));
        inventory.addInstrument("V95693", 1499.95,
                makeGuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("V9512", 1549.95,
                makeGuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("122784", 5495.95,
                makeGuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6, Wood.MAHOGANY, Wood.ADIRONDACK));
        inventory.addInstrument("76531", 6295.95,
                makeGuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("70108276", 2295.95,
                makeGuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("82765501", 1890.95,
                makeGuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY));
        inventory.addInstrument("77023", 6275.95,
                makeGuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
        inventory.addInstrument("1092", 12995.95,
                makeGuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD, Wood.CEDAR));
        inventory.addInstrument("566-62", 8999.95,
                makeGuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 12, Wood.COCOBOLO, Wood.CEDAR));
        inventory.addInstrument("6 29584", 2100.95,
                makeGuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAPLE));
        inventory.addInstrument("9019920", 5495.99, makeSpec(InstrumentType.MANDOLIN, Builder.GIBSON,
                "F5-G", Type.ACOUSTIC, Map.of("backWood", Wood.MAPLE, "topWood", Wood.MAPLE)));
        inventory.addInstrument("8900231", 2945.95, makeSpec(InstrumentType.BANJO, Builder.GIBSON,
                "RB-3", Type.ACOUSTIC, Map.of("numStrings", 5,"backWood", Wood.MAPLE)));
        return inventory;
    }

    private static InstrumentSpec makeGuitarSpec(Builder builder, String model, Type type, int numStrings,
                                                 Wood backWood, Wood topWood) {
        InstrumentSpec spec = new InstrumentSpec();
        spec.setProperty("instrumentType", InstrumentType.GUITAR);
        spec.setProperty("builder", builder);
        spec.setProperty("model", model);
        spec.setProperty("type", type);
        spec.setProperty("numStrings", numStrings);
        spec.setProperty("backWood", backWood);
        spec.setProperty("topWood", topWood);
        return spec;
    }

    @SuppressWarnings("SameParameterValue")
    private static InstrumentSpec makeSpec(InstrumentType instrumentType, Builder builder, String model, Type type,
                                           Map<String, Object> otherProps) {
        InstrumentSpec spec = new InstrumentSpec();
        spec.setProperty("instrumentType", instrumentType);
        spec.setProperty("builder", builder);
        spec.setProperty("model", model);
        spec.setProperty("type", type);
        otherProps.forEach(spec::setProperty);
        return spec;
    }
}
