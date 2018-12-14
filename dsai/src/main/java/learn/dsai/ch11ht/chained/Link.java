package learn.dsai.ch11ht.chained;

import learn.dsai.ch11ht.KeyLong;

public class Link implements KeyLong {
    private final long key;
    public Link next;

    public Link(long key) {
        this.key = key;
    }

    @Override
    public long getKey() {
        return key;
    }

    @Override
    public String toString() {
        return Long.toString(key);
    }
}
