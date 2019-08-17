package learn.dsajg6e.ch09priorityqueues;

import java.util.Comparator;

/**
 * CF-9.3
 * A comparator that evaluates strings based on their lengths.
 */
public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}
