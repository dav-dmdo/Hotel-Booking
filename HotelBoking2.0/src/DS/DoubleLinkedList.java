/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.DoubleNode;

/**

Esta clase representa una lista doblemente enlazada genérica que puede contener cualquier tipo de dato.

Proporciona métodos para agregar, eliminar y buscar nodos en la lista.

@author david

@param <T> el tipo de datos de los elementos en la lista
*/
public class DoubleLinkedList<T> {
    private int size;
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private final DataTypeMethods<T> dtm;
    
    
    /**
Constructor para la clase DoubleLinkedList.
Inicializa una lista vacía con un objeto DataTypeMethods para realizar comparaciones en los elementos de la lista.
@param dtm el objeto DataTypeMethods a utilizar para comparaciones
*/

    public DoubleLinkedList(DataTypeMethods<T> dtm) {
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.dtm = dtm;
    }
    /**

Devuelve si la lista está vacía.
@return verdadero si la lista está vacía, falso de lo contrario
*/
    public boolean isEmpty(){
        return  size == 0;
    }
    
    /**

Agrega un elemento al final de la lista.
@param data el elemento a agregar a la lista
*/
    
    public void add(T data){        
        addLast(data);
    }
    
    /**

Agrega un elemento al final de la lista.
@param data el elemento a agregar a la lista
*/
    
    private void addLast(T data){
        if (isEmpty()){
            head = tail = new DoubleNode<>(data, null, null);
        }else{
            tail.next(new DoubleNode<>(data, tail, null));
            tail(tail.next());
        }
        size++;
    }
    
    /**

Agrega un elemento al principio de la lista.

@param data el elemento a agregar a la lista
*/
    
    private void addFirst(T data){
        
        if (isEmpty()){
            head = tail = new DoubleNode<> (data, null, null);
        }else{
            head.prev(new DoubleNode<>(data, null, head));
            head(head.prev());
        }
        size++;
    }
    
    /**

Elimina el primer elemento de la lista y devuelve su valor.
@return el valor del primer elemento de la lista, o nulo si la lista está vacía
*/
    
    public T deleteFirstT(){
        DoubleNode<T> toDelete = deleteFirstNode();
        if (toDelete != null)
            return toDelete.data();
        return null;        
    }
    /**

Elimina el primer elemento de la lista y devuelve su nodo.
@return el nodo del primer elemento de la lista, o nulo si la lista está vacía
*/
    
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
    
    /**

Elimina el último elemento de la lista y devuelve su nodo.
@return el nodo del último elemento de la lista, o nulo si la lista está vacía
*/
    
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
    
    /**

Elimina un nodo de la lista.
@param toDelete el nodo a eliminar de la lista
@return el nodo eliminado, o nulo si el nodo no se encuentra en la lista
*/
    
    public DoubleNode<T> remove(DoubleNode<T> toDelete){
        if (toDelete.prev() == null)
            return deleteFirstNode();
        if (toDelete.next() == null)
            return deleteLastNode();
        skip(toDelete);
        size--;
        return toDelete;        
    }
    
    /**

Método auxiliar para eliminar un nodo de la lista.
@param toDelete el nodo a eliminar de la lista
*/
    
    private void skip(DoubleNode<T> toDelete){
        toDelete.next().prev(toDelete.prev());
        toDelete.prev().next(toDelete.next());        
    }
    
    /**

Busca un nodo en la lista que contenga un elemento específico.
@param data el elemento a buscar en la lista
@return el nodo que contiene el elemento, o nulo si el elemento no se encuentra en la lista
*/
    
    private DoubleNode<T> search(T data){
        DoubleNode<T> aux = head;
        if(!isEmpty()){
            boolean stop = false;
            while ((aux!=null) && (!stop)){
                stop = (dtm().isEqual(aux.data(), data));
                aux = (stop)? aux:aux.next();
            }               
        }
        return aux;
    }
    /**

Elimina el nodo en la lista que contiene un elemento específico.
@param data el elemento a eliminar de la lista
@return el nodo que se eliminó, o nulo si el elemento no se encuentra en la lista
*/
    
    private DoubleNode<T> delete(T data){
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

    /**
     * @return the dtm
     */
    public DataTypeMethods<T> dtm() {
        return dtm;
    }   
    
}
