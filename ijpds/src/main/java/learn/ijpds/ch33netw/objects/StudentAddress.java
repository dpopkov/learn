package learn.ijpds.ch33netw.objects;

import java.io.Serializable;
import java.util.Objects;

public class StudentAddress implements Serializable {
    private final String name;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public StudentAddress(String name, String street, String city, String state, String zip) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress that = (StudentAddress) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zip, that.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, city, state, zip);
    }

    @Override
    public String toString() {
        return "StudentAddress{name='" + name + '\'' +
                ", street='" + street + '\'' + ", city='" + city + '\'' +
                ", state='" + state + '\'' + ", zip='" + zip + '\'' + '}';
    }
}
