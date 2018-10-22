/* 9.4 */
package learn.core1.ch09collections;

import java.util.Objects;

/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        return partNumber == other.partNumber && Objects.equals(description, other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber, other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }

    @Override
    public String toString() {
        return "Item{description='" + description + "', partNumber=" + partNumber + '}';
    }
}
