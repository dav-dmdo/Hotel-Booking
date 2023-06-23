/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author david
 * @param <T>
 */
public interface DataTypeMethods<T> {
    
    boolean isEqual(T data1, T data2);
    
    boolean greaterThan(T data1, T data2);
    
    boolean lessThan(T data1, T data2); 

    String toString(T data);
    
    Integer getKey(T data);    
    
}
