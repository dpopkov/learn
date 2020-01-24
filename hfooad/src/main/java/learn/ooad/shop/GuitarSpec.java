package learn.ooad.shop;

import java.util.Objects;

public class GuitarSpec extends InstrumentSpec {

    private final int numStrings;

    public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.numStrings = numStrings;
    }


    public int getNumStrings() {
        return numStrings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) {
            return false;
        }
        GuitarSpec that = (GuitarSpec) o;
        return numStrings == that.numStrings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numStrings);
    }
}
