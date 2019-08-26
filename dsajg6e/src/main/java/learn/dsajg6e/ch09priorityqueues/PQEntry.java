package learn.dsajg6e.ch09priorityqueues;

/** Composes a key and a value into a single object. */
public class PQEntry<K, V> implements Entry<K, V> {
    private K key;
    private V value;

    public PQEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    protected void setKey(K key) {
        this.key = key;
    }

    protected void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + '}';
    }
}
