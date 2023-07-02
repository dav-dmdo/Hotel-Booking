/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.DoubleNode;
import static ControllerAndRelated.DoubleLinkedListMethods.*;

/**
 * Clase que implementa una Hash Table, una tabla Hash, que utiliza una
 * estructura de datos de lista doblemente enlazada para manejar los elementos
 * de la tabla. La tabla tiene un tamaño fijo determinado por la capacidad. La
 * tabla Hash utiliza una función hash para calcular la posición de los
 * elementos en la tabla.
 *
 * @param <T> tipo de dato que se almacena en la tabla
 * @author david
 * @param <T>
 */
public class HashTable<T> {

    public final DoubleLinkedList<T>[] table; //cada posicion del array es una lista doble
    private final Integer capacity; //tamano del array  (load factor<0.75)
    private Integer size;
    private final DataTypeMethods<T> dtm;
    private final boolean keyType; //True means key type is String

    /**
     *
     * Constructor de la clase HashTable
     *
     * @param capacity tamaño de la tabla Hash
     * @param dtm objeto DataTypeMethods que contiene los métodos para obtener
     * las claves numéricas o de texto
     * @param keyType indica el tipo de clave (true si es String)
     */
    public HashTable(Integer capacity, DataTypeMethods<T> dtm, boolean keyType) {
        this.size = 0;
        this.capacity = capacity;
        this.dtm = dtm;
        this.table = new DoubleLinkedList[capacity];
        this.keyType = keyType;
        for (int i = 0; i < table.length; i++) {
            table[i] = new DoubleLinkedList<>(dtm);
        }
    }

    /**
     * Inserta un nuevo elemento en la tabla Hash, calculando su posición
     * mediante una función hash.
     *
     * @param data
     */
    public void insert(T data) {
        Integer key = getKey(data);
        DoubleLinkedList<T> list = table[key];
        list.add(data);
        size++;
    }

    /**
     * Busca y elimina un elemento en la tabla Hash utilizando su clave (key).
     *
     * @param key
     * @return
     */
    public DoubleNode<T> delete(String key) {
        DoubleNode<T> aux = null;
        Integer hash = hashFunction(key);
        DoubleLinkedList<T> list = table[hash];
        if (!list.isEmpty()) {
            aux = searchStringKey(list, key);

        }
        if (aux != null) {
            deleteByStringKey(list, key);
            size--;
        }

        return aux;
    }

    /**
     * Busca un elemento en la tabla Hash utilizando su clave (key)
     *
     * @param key clave del elemento a buscar
     * @return DoubleNode que contiene el elemento buscado, o null si no se
     * encuentra el elemento.
     */
//    public DoubleLinkedList<T> searchByKey(Object key) {
//        Integer hash = (keyType) ? hashFunction((String) key) : hashFunction((Integer) key);
//        DoubleLinkedList<T> list = table[hash];
//        return list;
//    }
    public DoubleNode<T> search(String key) {
        DoubleNode<T> aux = null;
        Integer hash = this.hashFunction(key);
        DoubleLinkedList<T> list = table[hash];
        if (!list.isEmpty()) {
            aux = searchStringKey(list, key);
        }
        return aux;
    }

    /**
     *
     * Calcula la clave del elemento (data) que se va a insertar en la tabla
     * Hash.
     *
     * @param data el elemento a insertar
     * @return la clave numérica o de texto correspondiente al elemento (data)
     */
    private Integer getKey(T data) {
        if (keyType) {
            String key = getStringKey(data);
            return hashFunction(key);
        }
        Integer key = getNumericalKey(data);
        return hashFunction(key);
    }

    /**
     *
     * Obtiene la clave numérica correspondiente al elemento (data).
     *
     * @param data el elemento del cual se va a obtener la clave numérica
     * @return la clave numérica correspondiente al elemento (data)
     */
    private Integer getNumericalKey(T data) {
        return dtm().getNumericalKey(data);
    }

    /**
     *
     * Obtiene la clave de texto correspondiente al elemento (data).
     *
     * @param data el elemento del cual se va a obtener la clave de texto
     * @return la clave de texto correspondiente al elemento (data)
     */
    private String getStringKey(T data) {
        return dtm().getStringKey(data);
    }

    /**
     *
     * Calcula un valor disperso utilizando la clave de texto.
     *
     * @param key clave de texto del elemento que se va a insertar en la tabla
     * Hash
     * @return un valor disperso calculado a partir de la clave de texto
     */
    private Integer disperse(String key) {
        Integer sum = 0;
        char[] chars = key.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += chars[i] * (1 + i);
        }
        return sum;
    }

    /**
     *
     * Aplica la función hash a la clave de texto del elemento a insertar.
     *
     * @param key clave de texto del elemento a insertar
     * @return la posición en la tabla Hash correspondiente al elemento a
     * insertar
     */
    public Integer hashFunction(String key) {
        return (disperse(key) % capacity);
    }

    /**
     *
     * Calcula un valor disperso utilizando la clave numérica.
     *
     * @param key clave numérica del elemento que se va a insertar en la tabla
     * Hash
     * @return un valor disperso calculado a partir de la clave numérica
     */
    private Integer disperse(Integer key) {
        Integer sum = key;
        return sum;
    }

    /**
     *
     * Aplica la función hash a la clave numérica del elemento a insertar.
     *
     * @param key clave numérica del elemento a insertar
     * @return la posición en la tabla Hash correspondiente al elemento a
     * insertar
     */
    public Integer hashFunction(Integer key) {
        return (disperse(key) % capacity);
    }

    /**
     * @return the dtm
     */
    public DataTypeMethods<T> dtm() {
        return dtm;
    }

    /**
     * @return the table
     */
    public DoubleLinkedList<T>[] table() {
        return table;
    }

}
