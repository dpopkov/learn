package learn.dsajg6e.ch10maps.exer;

import learn.dsajg6e.ch07list.ArrayList;
import learn.dsajg6e.ch09pq2.Entry;
import learn.dsajg6e.ch10maps.AbstractHashMap;

public class C1040LinkedChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private static class Node<K, V> {
        private MapEntry<K, V> entry;
        private Node<K, V> next;

        public Node(MapEntry<K, V> entry) {
            this.entry = entry;
        }

        public MapEntry<K, V> getEntry() {
            return entry;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    private Node<K, V>[] table;

    public C1040LinkedChainHashMap() {
        super(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public C1040LinkedChainHashMap(int capacity, double loadFactor, int prime, long scale, long shift) {
        super(capacity, loadFactor, prime, scale, shift);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable(int capacity) {
        table = (Node<K, V>[]) new Node[capacity];
    }

    @Override
    protected V bucketGet(int hash, K key) {
        Node<K, V> bucket = table[hash];
        if (bucket == null) {
            return null;
        }
        return findInBucket(bucket, key);
    }

    @Override
    protected boolean bucketContainsKey(int hash, K key) {
        Node<K, V> bucket = table[hash];
        if (bucket == null) {
            return false;
        }
        return findInBucket(bucket, key) != null;
    }

    private V findInBucket(Node<K, V> node, K key) {
        while (node != null) {
            Entry<K, V> entry = node.getEntry();
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    protected V bucketPut(int hash, K key, V value) {
        V oldValue = null;
        Node<K, V> bucket = table[hash];
        if (bucket == null) {
            MapEntry<K, V> entry = new MapEntry<>(key, value);
            table[hash] = new Node<>(entry);
            increaseSize(1);
        } else {
            oldValue = putToBucketLinkedList(bucket, key, value);
            if (oldValue == null) {
                increaseSize(1);
            }
        }
        return oldValue;
    }

    @Override
    protected V bucketPutIfAbsent(int hash, K key, V value) {
        V oldValue = null;
        Node<K, V> bucket = table[hash];
        if (bucket == null) {
            MapEntry<K, V> entry = new MapEntry<>(key, value);
            table[hash] = new Node<>(entry);
            increaseSize(1);
        } else {
            oldValue = putIfAbsentToBucketLinkedList(bucket, key, value);
            if (oldValue == null) {
                increaseSize(1);
            }
        }
        return oldValue;
    }

    private V putIfAbsentToBucketLinkedList(Node<K, V> node, K key, V value) {
        V oldValue = null;
        Node<K, V> prev = null;
        while (node != null) {
            MapEntry<K, V> entry = node.getEntry();
            if (entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                break;
            }
            prev = node;
            node = node.getNext();
        }
        if (oldValue == null && prev != null) {
            prev.setNext(new Node<>(new MapEntry<>(key, value)));
        }
        return oldValue;
    }

    private V putToBucketLinkedList(Node<K, V> node, K key, V value) {
        V oldValue = null;
        Node<K, V> prev = null;
        while (node != null) {
            MapEntry<K, V> entry = node.getEntry();
            if (entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                entry.setValue(value);
                break;
            }
            prev = node;
            node = node.getNext();
        }
        if (oldValue == null && prev != null) {
            prev.setNext(new Node<>(new MapEntry<>(key, value)));
        }
        return oldValue;
    }

    @Override
    protected V bucketRemove(int hash, K key) {
        Node<K, V> bucket = table[hash];
        if (bucket == null) {
            return null;
        }
        V oldValue = removeFromBucket(hash, bucket, key);
        if (oldValue != null) {
            decreaseSize(1);
        }
        return oldValue;
    }

    private V removeFromBucket(int indexInTable, Node<K, V> node, K key) {
        Node<K, V> prev = null;
        Node<K, V> toRemove = null;
        while (node != null) {
            MapEntry<K, V> entry = node.getEntry();
            if (entry.getKey().equals(key)) {
                toRemove = node;
                break;
            } else {
                prev = node;
                node = node.getNext();
            }
        }
        if (toRemove != null) {
            V oldValue = toRemove.getEntry().getValue();
            if (prev != null) {
                prev.setNext(toRemove.getNext());
            } else {
                table[indexInTable] = toRemove.getNext();
            }
            toRemove.setNext(null);
            return oldValue;
        }
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (Node<K, V> bucket : table) {
            if (bucket != null) {
                Node<K, V> node = bucket;
                while (node != null) {
                    buffer.add(node.getEntry());
                    node = node.getNext();
                }
            }
        }
        return buffer;
    }
}
