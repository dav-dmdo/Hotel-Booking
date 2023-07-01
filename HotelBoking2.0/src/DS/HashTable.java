/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.DoubleNode;
import static ControllerAndRelated.DoubleLinkedListMethods.*;

/**
 *
 * @author david
 */
public class HashTable<T> {

    private DoubleLinkedList<T>[] table; //cada posicion del 
    private Integer capacity;
    private Integer size;
    private final DataTypeMethods<T> dtm;
    private final boolean keyType; //True means key type is String

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
     *
     * @param data
     */

    public void insert(T data) {
        Integer key = getKey(data);
        DoubleLinkedList<T> list = table()[key];
        list.addLast(data);
        size++;
    }

    /**
     *
     * @param key
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
     *
     * @param key
     * @return
     */

//    public DoubleLinkedList<T> searchByKey(Object key) {
//        Integer hash = (keyType) ? hashFunction((String) key) : hashFunction((Integer) key);
//        DoubleLinkedList<T> list = table[hash];
//        return list;
//    }

    public DoubleNode<T> search(String key){
        DoubleNode<T> aux = null;
        Integer hash = this.hashFunction(key);
        DoubleLinkedList<T> list = table[hash];
        if (!list.isEmpty()){
            aux = searchStringKey(list, key);
        }
        return aux;
    }
    
    
    
//    
//    public T searchByKey(Object key) {
//        String key2 = key.toString();
//        if(!keyType){
//            Integer key= Integer.parseInt(key2);
//        }
//        
//        Integer hash = hashFuction(key);
//        DoubleLinkedList<T> list = table[hash];
//        DoubleNode<T> node = searchStringKey(list, key.toString());
//        if (node != null) {
//            return node.data();
//        }
//        return null;
//    }

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

    private Integer disperse(String key) {
        Integer sum = 0;
        char[] chars = key.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            sum += chars[i] * (1+i);
        }
        return sum;
    }

    public Integer hashFunction(String key) {
        return (disperse(key) % capacity);
    }

    private Integer disperse(Integer key) {
        Integer sum = key;
        return sum;
    }

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
