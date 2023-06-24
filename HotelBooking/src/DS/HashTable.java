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

    private int capacity;        // Capacidad máxima de la tabla
    private Object[] keys;       // Arreglo para almacenar las claves
    private Object[] values;     // Arreglo para almacenar los valores correspondientes a cada clave

    // Constructor que recibe la capacidad de la tabla
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.keys = new Object[capacity];    // Se crea un arreglo de claves vacío con la capacidad dada
        this.values = new Object[capacity];  // Se crea un arreglo de valores vacío con la capacidad dada
    }

    // Método para insertar un par clave-valor en la tabla
    public void insert(Object key, Object value) {
        int hash1 = Math.abs(key.hashCode() % capacity);    // Se calcula la posición en la tabla hash usando el hashcode de la clave
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);  // Se calcula un segundo hash para manejar colisiones

        // Se busca una posición libre en la tabla, usando el segundo hash para saltar a posiciones diferentes
        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        // Se inserta la clave y el valor en la posición encontrada
        keys[hash1] = key;
        values[hash1] = value;
    }

    // Método para obtener el valor correspondiente a una clave en la tabla
    public Object get(Object key) {
        int hash1 = Math.abs(key.hashCode() % capacity);    // Se calcula la posición en la tabla hash usando el hashcode de la clave
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);  // Se calcula un segundo hash para manejar colisiones

        // Se busca la posición correspondiente a la clave, usando el segundo hash para saltar a posiciones diferentes
        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        // Se devuelve el valor correspondiente a la clave
        return values[hash1];
    }

    // Método para recorrer la tabla y mostrar las claves y valores almacenados
    public void traverse() {
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                System.out.println(keys[i] + ": " + values[i]);
            }
        }
    }

    // Método para buscar una clave en la tabla y devolver un mensaje que indique si está o no
    public String findKey(Object key) {
        int hash1 = Math.abs(key.hashCode() % capacity);    // Se calcula la posición en la tabla hash usando el hashcode de la clave
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);  // Se calcula un segundo hash para manejar colisiones

        // Se busca la posición correspondiente a la clave, usando el segundo hash para saltar a posiciones diferentes
        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        // Si se encontró la clave, se devuelve un mensaje con su valor asociado; de lo contrario, se devuelve un mensaje de que no se encontró
        if (keys[hash1] != null && keys[hash1].equals(key)) {
            return "El usuario: " + key + " esta hospedado en la habitacion: " + values[hash1];
        } else {
            return "El usuario: " + key + " no se encuentra registrado.";
        }
    }

    // Método para leer datos desde un archivo y almacenarlos en la tabla
    public void read(String filename, JTextArea b, JTextField c, Integer cont) {
        HashTable hashtable = new HashTable(1000);   // Se crea una tabla hash vacía
        hashtable.clear();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));   // Se crea un lector para el archivo
            String line;
            while ((line = reader.readLine()) != null) {   // Se lee el archivo línea por línea
                String[] data = line.split(",");   // Se separan los datos por comas
                Object key = data[1].trim() + " " + data[2].trim();   // Se crea una clave a partir de los datos
                Object value = data[0].trim();   //Se obtiene el valor correspondiente a la clave en los datos

                hashtable.insert(key, value);   // Se inserta la clave y el valor en la tabla hash

            }


            String client = hashtable.findKey(c.getText());
            b.setText(client);

            if (cont == 0) {
                hashtable.traverse();
                
            }

            reader.close();   // Se cierra el lector
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            keys[i] = null;
            values[i] = null;
        }
    }

    // Método para obtener la cantidad de elementos almacenados en la tabla
    public int size() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (keys[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void deletebkey(Object key) {
        int hash1 = Math.abs(key.hashCode() % capacity);    // Se calcula la posición en la tabla hash usando el hashcode de la clave
        int hash2 = Math.abs(key.hashCode() % (capacity - 2) + 1);  // Se calcula un segundo hash para manejar colisiones

        // Se busca la posición correspondiente a la clave, usando el segundo hash para saltar a posiciones diferentes
        while (keys[hash1] != null && !keys[hash1].equals(key)) {
            hash1 = (hash1 + hash2) % capacity;
        }

        // Si se encontró la clave, se elimina el elemento de la tabla
        if (keys[hash1] != null && keys[hash1].equals(key)) {
            keys[hash1] = null;
            values[hash1] = null;
        }
    }
}
