package learn.ooad.shop;

import java.util.Objects;

public class MandolinSpec extends InstrumentSpec {
    private Style style;

    public MandolinSpec(Builder builder, String model, Type type, Style style, Wood backWood, Wood topWood) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        MandolinSpec that = (MandolinSpec) obj;
        return style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style);
    }
}
