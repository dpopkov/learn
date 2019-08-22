package learn.dsajg6e.ch09priorityqueues;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Contains methods for assertions of {@link Entry} objects.
 */
public class EntryAssertions {
    /**
     * Asserts that the specified {@link Entry} instance's key and value
     * satisfy the expected key and value.
     * @param entry the tested entry instance
     * @param key expected key of the entry
     * @param value expected value of the entry
     * @param <K> type of key
     * @param <V> type of value
     */
    public static <K, V> void assertEntry(Entry<K, V> entry, K key, V value) {
        assertThat(entry.getKey(), is(key));
        assertThat(entry.getValue(), is(value));
    }
}
