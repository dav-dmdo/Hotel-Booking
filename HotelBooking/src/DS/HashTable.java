/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

    public String findKey(Object key) {
        int hash1 = Math.abs(key.hashCode() % capacity);
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);

        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        if (keys[hash1] != null && keys[hash1].equals(key)) {
            return "El usuario: " + key + " esta hospedado en la habitacion: " + values[hash1];
        } else {
            return "El usuario: " + key + " no se encuentra registrado.";
        }
    }

    public void read(String filename, String a, JTextArea b, JTextField c) {
        HashTable hashtable = new HashTable(1000);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String key = data[1].trim() + " " + data[2].trim();
                String value = data[0].trim();
                hashtable.insert(key, value);
                if (key.equals(c.getText())) {
                    b.setText("El usuario: " + key + " esta hospedado en la habitacion: " + value);
                } else {
                    cont++;
                }

            }

            if (cont == 301) {
                String client = findKey(c.getText());
                b.setText(client);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int size() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                count++;
            }
        }
        return count;
    }
}
