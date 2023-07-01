/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.DoubleNode;
import static ControllerAndRelated.DoubleLinkedListMethods.*;

/**
 * Esta clase representa una tabla Hash que almacena objetos del tipo T. La tabla
 * utiliza una lista doblemente enlazada para manejar las colisiones. 
 * 
 * @param <T> El tipo de objeto que se almacenará en la tabla Hash. 
 */
public class HashTable<T> {

    private final DoubleLinkedList<T>[] table; //cada posicion del array es una lista doble
    private final Integer capacity; //tamano del array (load factor<0.75)
    private Integer size;
    private final DataTypeMethods<T> dtm;
    private final boolean keyType; //True significa que el tipo de clave es String

    /**
     * Construye una tabla Hash con la capacidad especificada, el objeto que contiene los métodos de comparación 
     * de tipos de datos T y un booleano que indica si la clave es de tipo String. Se crea un array de listas doblemente enlazadas
     * con la capacidad especificada y se inicializa cada lista con un objeto DoubleLinkedList. 
     * 
     * @param capacity La capacidad de la tabla Hash.
     * @param dtm El objeto que contiene los métodos de comparación de tipos de datos T.
     * @param keyType Un booleano que indica si la clave es de tipo String.
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
     * Inserta el objeto especificado en la tabla Hash. Se obtiene la clave del objeto y se utiliza para
     * obtener la lista correspondiente en la tabla, luego se agrega el objeto a la lista y se incrementa el tamaño de la tabla. 
     * 
     * @param data El objeto que se va a insertar en la tabla Hash.
     */
    public void insert(T data) {
        Integer key = getKey(data);
        DoubleLinkedList<T> list = table[key];
        list.add(data);
        size++;
    }

    /**
     * Elimina el objeto que tiene la clave especificada de la tabla Hash. Se utiliza la función hash de la clave
     * para obtener la lista correspondiente en la tabla y se busca el objeto en la lista. Si se encuentra, se elimina 
     * de la lista y se decrementa el tamaño de la tabla. 
     * 
     * @param key La clave del objeto que se va a eliminar de la tabla Hash.
     * @return El nodo doble que contiene el objeto eliminado de la lista o null si no se encontró el objeto.
     */
    public DoubleNode<T> delete(String key) {
        DoubleNode<T> aux= null;
        Integer hash = hashFunction(key);
        DoubleLinkedList<T> list = table[hash];
        if(!list.isEmpty()){
            System.out.println(list.dtm().toString(list.head().data()));
            aux = searchStringKey(list, key);
            
        }
        if (aux != null){
            deleteByStringKey(list, key);
            size--;
        }
        
        
        return aux;
    }

    /**
     * Busca el objeto que tiene la clave especificada en la tabla Hash. Se utiliza la función hash de la clave
     * para obtener la lista correspondiente en la tabla y se busca el objeto en la lista. Si se encuentra, se retorna
     * el nodo doble que contiene el objeto, sino se retorna null.
     * 
     * @param key La clave del objeto que se va a buscar en la tabla Hash.
     * @return El nodo doble que contiene el objeto que se buscó en la lista o null si no se encontró el objeto.
     */
    public DoubleNode<T> search(String key){
        DoubleNode<T> aux = null;
        Integer hash = this.hashFunction(key);
        DoubleLinkedList<T> list = table[hash];
        if (!list.isEmpty()){
            aux = searchStringKey(list, key);
        }
        return aux;
    }
    
    private Integer getKey(T data) {
        if (keyType) {
            String key = getStringKey(data);
            return hashFunction(key);
        }
        Integer key = getNumericalKey(data);
        return hashFunction(key);
    }

    private Integer getNumericalKey(T data) {
        return dtm().getNumericalKey(data);
    }

    private String getStringKey(T data) {
        return dtm().getStringKey(data);
    }

    /**
     * Aplica la función dispersa a la clave especificada. Suma el valor ASCII de cada caracter de la clave multiplicado por su posición
    en la clave y retorna el resultado de la suma. 
     * 
     * @param key La clave que se va a dispersar.
     * @return El resultado de aplicar la función dispersa a la clave.
     */
    private Integer disperse(String key) {
        Integer sum = 0;
        char[] chars = key.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            sum += chars[i] * (1+i);
        }
        return sum;
    }

    /**
     * Calcula el índice de la tabla Hash correspondiente a la clave especificada. Se aplica la función dispersa a la clave 
     * y se retorna el resultado de la operación módulo con la capacidad de la tabla. 
     * 
     * @param key La clave que se va a utilizar para calcular el índice de la tabla Hash.
     * @return El índice de la tabla Hash correspondiente a la clave especificada.
     */
    public Integer hashFunction(String key) {
        return (disperse(key) % capacity);
    }

    private Integer disperse(Integer key) {
        Integer sum = key;
        return sum;
    }

    /**
     * Calcula el índice de la tabla Hash correspondiente a la clave especificada. Se aplica la función dispersa a la clave 
     * y se retorna el resultado de la operación módulo con la capacidad de la tabla. 
     * 
     * @param key La clave que se va a utilizar para calcular el índice de la tabla Hash.
     * @return El índice de la tabla Hash correspondiente a la clave especificada.
     */
    public Integer hashFunction(Integer key) {
        return (disperse(key) % capacity);
    }

    /**
     * Retorna el objeto que contiene los métodos de comparación de tipos de datos T.
     * 
     * @return El objeto que contiene los métodos de comparación de tipos de datos T.
     */
    public DataTypeMethods<T> dtm() {
        return dtm;
    }

    /**
     * Retorna el array de listas doblemente enlazadas que representa la tabla Hash.
     * 
     * @return El array de listas doblemente enlazadas que representa la tabla Hash.
     */
    public DoubleLinkedList<T>[] table() {
        return table;
    }  
}