package learn.ooad.shop;

import java.util.Objects;

public abstract class InstrumentSpec {
    private final Builder builder;
    private final String model;
    private final Type type;
    private final Wood backWood;
    private final Wood topWood;

    public InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentSpec that = (InstrumentSpec) o;
        return builder == that.builder &&
                Objects.equals(model, that.model) &&
                type == that.type &&
                backWood == that.backWood &&
                topWood == that.topWood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(builder, model, type, backWood, topWood);
    }
}
