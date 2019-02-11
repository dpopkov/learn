package learn.bj6e.ch11io;

import java.util.Objects;

public class CountryValue {
    private final String country;
    private final int value;

    public CountryValue(String country, int value) {
        this.country = country;
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public int getValue() {
        return value;
    }

    public boolean equalsByCountry(CountryValue other) {
        return other != null && Objects.equals(this.country, other.country);
    }
}
