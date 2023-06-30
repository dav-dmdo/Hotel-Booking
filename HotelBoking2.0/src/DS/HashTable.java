/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;

/**
 *
 * @author david
 */
public class HashTable <T> {
    private DoubleLinkedList<T>[] table; //cada posicion del 
    private Integer capacity;
    private Integer size;
    private DataTypeMethods<T> dtm;
    private final boolean keyType; //True means key type is String
    
    public HashTable(Integer capacity, DataTypeMethods<T> dtm, boolean keyType){
        this.size = 0;
        this.capacity= capacity;
        this.dtm = dtm;
        this.table = new DoubleLinkedList[capacity];
        this.keyType = keyType;
        for (int i = 0; i < table.length; i++) {
            table[i] = new DoubleLinkedList<>(dtm);            
        }
        
    }
   
    private Integer getKey(T data){
        if(keyType){
            String key = getStringKey(data);
            return hashFunction(key);
        }
            Integer key = getNumericalKey(data);
            return hashFunction(key);
    }
    
    private Integer getNumericalKey(T data){        
        return dtm.getNumericalKey(data);
    }
    
    private String getStringKey(T data){
        return dtm.getStringKey(data);
    }
    
    private Integer disperse(String key){
        Integer sum = null;
        char[] chars = key.toCharArray();
        for (int i = chars.length; i >= 0 ; i--) {
            sum += chars[i] * i ;            
        }
        return sum;
    }
    
    private Integer hashFunction(String key){
        return (disperse(key) % capacity);
    }
    
    private Integer disperse(Integer key){
        Integer sum = key; 
        return sum;
    }
    
    private Integer hashFunction(Integer key){
        return (disperse(key) % capacity);
    }
    
    
    
    
    
}
