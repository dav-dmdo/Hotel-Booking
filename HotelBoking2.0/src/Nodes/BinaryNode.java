/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodes;

/**
 *
 * @author david
 * @param <T>
 */
public class BinaryNode<T> {
    private BinaryNode<T> leftSon;
    private BinaryNode<T> rightSon;
    private T data;

    public BinaryNode( T data) {
        this.leftSon = null;
        this.rightSon = null;
        this.data = data;
    }
    
    public boolean isLeaf(){
        return (leftSon == null)&&(rightSon==null);
    }

    /**
     * @return the leftSon
     */
    public BinaryNode<T> leftSon() {
        return leftSon;
    }

    /**
     * @param leftSon the leftSon to set
     */
    public void leftSon(BinaryNode<T> leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * @return the rightSon
     */
    public BinaryNode<T> rightSon() {
        return rightSon;
    }

    /**
     * @param rightSon the rightSon to set
     */
    public void rightSon(BinaryNode<T> rightSon) {
        this.rightSon = rightSon;
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
