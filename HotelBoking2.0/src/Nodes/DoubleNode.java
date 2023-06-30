/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodes;

/**
 *
 * @author david
 */
public class DoubleNode<T> {
    private DoubleNode<T> prev, next;
    private T data;

    public DoubleNode( T data, DoubleNode<T> prev, DoubleNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    

    public DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * @return the prev
     */
    public DoubleNode<T> prev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void prev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    /**
     * @return the next
     */
    public DoubleNode<T> next() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void next(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * @return the data
     */
    public T data() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void data(T data) {
        this.data = data;
    }
    
    
    
}
