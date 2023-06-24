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
public class ListNode<T> {
 private T data;
 private ListNode <T> pNext;

 //Constructor.
 ListNode (T elem){
 data=elem;
 pNext=null;
 }

 //Getters and Setters.
 
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
     * @return the pNext
     */
    public ListNode <T> getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(ListNode <T> pNext) {
        this.pNext = pNext;
    }

    
}
