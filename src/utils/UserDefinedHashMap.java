package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UserDefinedHashMap<K, V> {
    private final int CAPACITY;
    private Bucket<K, V>[] buckets;
    private int size = 0;

    public UserDefinedHashMap(int capacity) {
        this.CAPACITY = capacity;
        buckets = new Bucket[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new Bucket<>();
        }
    }

    public int size() {
        return size;
    }

    private int getBucketNumber(K key) {
        return (key.hashCode() & 0xfffffff) % CAPACITY;
    }

    public boolean containsKey(K key) {
        int bucketIndex = getBucketNumber(key);
        return !(Objects.isNull(buckets[bucketIndex]) || Objects.isNull(getEntryByKey(key)));
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            Entry<K, V> entry = getEntryByKey(key);
            assert entry != null;
            entry.setValue(value);
        } else {
            int bucketIndex = getBucketNumber(key);
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new Bucket<>();
            }
            buckets[bucketIndex].addEntry(new Entry<>(key, value));
            size++;
        }
    }

    public V get(K key) {
        return containsKey(key) ? Objects.requireNonNull(getEntryByKey(key)).getValue() : null;
    }

    public void delete(K key) {
        if (!containsKey(key)) {
            return;
        }
        Bucket<K, V> targetBucket = buckets[getBucketNumber(key)];
        Entry<K, V> targetEntry = getEntryByKey(key);
        targetBucket.removeEntry(targetEntry);
        size--;
    }

    private Entry<K, V> getEntryByKey(K key) {
        int bucketIndex = getBucketNumber(key);
        Bucket<K, V> targetBucket = buckets[bucketIndex];
        for (Entry<K, V> entry : targetBucket.getEntries()) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    static class Bucket<K, V> {
        private final List<Entry<K, V>> entries;

        public Bucket() {
            entries = new LinkedList<>();
        }

        public List<Entry<K, V>> getEntries() {
            return entries;
        }

        public void addEntry(Entry<K, V> entry) {
            entries.add(entry);
        }

        public void removeEntry(Entry entry) {
            entries.remove(entry);
        }
    }

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
