/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS;

/**
 *
 * @author Andrea
 * @param <T>
 */
public class NodeABB<T>{
    private  NodeABB<T> left;
    private NodeABB<T> right;
    private T data;
    private int counter;
    
    //Constructors
    public NodeABB(T data){
        this.left = this.right = null;
        this.counter=0;
        this.data = data;
    }

    
    //Getters & Setters 
    
    /**
     * @return the left
     */
    public NodeABB<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(NodeABB<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public NodeABB<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(NodeABB<T> right) {
        this.right = right;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    
}
