/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

/**
 *
 * @author david
 */
public class HashTable {

    private int capacity;
    private Object[] keys;
    private Object[] values;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
    }

    public void insert(Object key, Object value) {
        int hash1 = Math.abs(key.hashCode() % capacity);
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);

        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        keys[hash1] = key;
        values[hash1] = value;
    }

    public Object get(Object key) {
        int hash1 = Math.abs(key.hashCode() % capacity);
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);

        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        return values[hash1];
    }

    public void traverse() {
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                System.out.println(keys[i] + ": " + values[i]);
            }
        }
    }

    public Object searchByKey(Object key) {
        int hash1 = Math.abs(key.hashCode() % capacity);
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);

        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        return keys[hash1] != null ? values[hash1] : null;
    }
}
