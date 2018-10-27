package learn.ijpds.ch17io.exercises;

public class Address {
    public static final int NAME_LENGTH = 32;
    public static final int STREET_LENGTH = 32;
    public static final int CITY_LENGTH = 20;
    public static final int STATE_LENGTH = 2;
    public static final int ZIP_LENGTH = 5;

    public static int getMaximumLength(int fieldPrefixLength) {
        return fieldPrefixLength + NAME_LENGTH
                + fieldPrefixLength + STREET_LENGTH
                + fieldPrefixLength + STATE_LENGTH
                + fieldPrefixLength + CITY_LENGTH
                + fieldPrefixLength + STATE_LENGTH
                + fieldPrefixLength + ZIP_LENGTH;
    }

    private final String name;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public Address(String name, String street, String city, String state, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
