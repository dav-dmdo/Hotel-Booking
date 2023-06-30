/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DS.NodeABB;

/**
 *
 * @author david
 * @param <T>
 */
public interface DataTypeMethods<T> {
    
    boolean isEqual(int data1, T data2);
    
    boolean greaterThan(int data1, T data2);
    
    boolean lessThan(int data1, T data2); 

    String toString(T data);
    
    Integer getKey(T data);    
    
}
