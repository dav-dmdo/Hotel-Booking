/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.DoubleNode;

/**
 *
 * @author david
 */
public class DoubleLinkedList<T> {
    private int size;
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private final DataTypeMethods<T> dtm;

    public DoubleLinkedList(DataTypeMethods<T> dtm) {
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.dtm = dtm;
    }
    
    public boolean isEmpty(){
        return  size == 0;
    }
    
    public void add(T data){
        
        addLast(data);
    }
    
    public void addLast(T data){
        if (isEmpty()){
            head = tail = new DoubleNode<>(data, null, null);
        }else{
            tail.next(new DoubleNode<>(data, tail, null));
            tail(tail.next());
        }
        size++;
    }
    
    public void addFirst(T data){
        
        if (isEmpty()){
            head = tail = new DoubleNode<> (data, null, null);
        }else{
            head.prev(new DoubleNode<>(data, null, head));
            head(head.prev());
        }
        size++;
    }
    
    public T deleteFirstT(){
        DoubleNode<T> toDelete = deleteFirstNode();
        if (toDelete != null)
            return toDelete.data();
        return null;        
    }
    
    public DoubleNode<T> deleteFirstNode(){                
        DoubleNode<T> toDelete = head;        
        if (!isEmpty()){
            head(head.next());            
            size--;
            if(isEmpty()){
                tail = null;
            }else{
                head.prev();
            }                    
        }
        return toDelete;         
    }
    
    public DoubleNode<T> deleteLastNode(){                
        DoubleNode<T> toDelete = tail;        
        if (!isEmpty()){
            tail(tail.prev());            
            size--;
            if(isEmpty()){
                head = null;
            }else{
                tail.next(null);
            }                    
        }
        return toDelete;         
    }
    
    private DoubleNode<T> remove(DoubleNode<T> toDelete){
        if (toDelete.prev() == null)
            return deleteFirstNode();
        if (toDelete.next() == null)
            return deleteLastNode();
        skip(toDelete);
        size--;
        return toDelete;        
    }
    
    private void skip(DoubleNode<T> toDelete){
        toDelete.next().prev(toDelete.prev());
        toDelete.prev().next(toDelete.next());
        
    }
    public DoubleNode<T> search(T data){
        DoubleNode<T> aux = head;
        if(!isEmpty()){
            boolean stop = false;
            while ((aux!=null) && (!stop)){
                stop = (dtm.isEqual(aux.data(), data));
                aux = (stop)? aux:aux.next();
            }               
        }
        return aux;
    }
    
    public DoubleNode<T> delete(T data){
        DoubleNode<T> found = search(data);
        if (found!=null){
            return remove(found);
        }else{
            return null;
        }
            
        
    }
    
    
    

    /**
     * @return the size
     */
    public int size() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void size(int size) {
        this.size = size;
    }

    /**
     * @return the head
     */
    public DoubleNode<T> head() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void head(DoubleNode<T> head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public DoubleNode<T> tail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void tail(DoubleNode<T> tail) {
        this.tail = tail;
    }
    
    
    
    
    
    
}
