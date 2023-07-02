/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.DoubleNode;

/**
 *
 * Clase que implementa una lista doblemente enlazada, la cual se utiliza en la
 * implementación de una tabla Hash.
 *
 * @param <T> tipo de dato que se almacena en la lista
 *
 * @author david
 */
public class DoubleLinkedList<T> {

    private int size;
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private final DataTypeMethods<T> dtm;

    /**
     *
     * Constructor de la clase DoubleLinkedList.
     *
     * @param dtm objeto DataTypeMethods que contiene los métodos para obtener
     * las claves numéricas o de texto.
     */
    public DoubleLinkedList(DataTypeMethods<T> dtm) {
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.dtm = dtm;
    }

    /**
     *
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * Añade un elemento al final de la lista.
     *
     * @param data dato a insertar en la lista.
     */
    public void add(T data) {
        addLast(data);
    }

    /**
     *
     * Añade un elemento al final de la lista.
     *
     * @param data dato a insertar en la lista.
     */
    private void addLast(T data) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(data, null, null);
        } else {
            tail.next(new DoubleNode<>(data, tail, null));
            tail(tail.next());
        }
        size++;
    }

    /**
     *
     * Añade un elemento al inicio de la lista.
     *
     * @param data dato a insertar en la lista.
     */

    private void addFirst(T data) {

        if (isEmpty()) {
            head = tail = new DoubleNode<>(data, null, null);
        } else {
            head.prev(new DoubleNode<>(data, null, head));
            head(head.prev());
        }
        size++;
    }

    /**
     *
     * Elimina y devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista, o null si la lista está vacía.
     */
    public T deleteFirstT() {
        DoubleNode<T> toDelete = deleteFirstNode();
        if (toDelete != null) {
            return toDelete.data();
        }
        return null;
    }

    /**
     *
     * Elimina y devuelve el primer nodo de la lista.
     *
     * @return el primer nodo de la lista, o null si la lista está vacía.
     */
    public DoubleNode<T> deleteFirstNode() {
        DoubleNode<T> toDelete = head;
        if (!isEmpty()) {
            head(head.next());
            size--;
            if (isEmpty()) {
                tail = null;
            } else {
                head.prev();
            }
        }
        return toDelete;
    }

    /**
     *
     * Elimina y devuelve el último nodo de la lista.
     *
     * @return el último nodo de la lista, o null si la lista está vacía.
     */

    public DoubleNode<T> deleteLastNode() {
        DoubleNode<T> toDelete = tail;
        if (!isEmpty()) {
            tail(tail.prev());
            size--;
            if (isEmpty()) {
                head = null;
            } else {
                tail.next(null);
            }
        }
        return toDelete;
    }

    /**
     *
     * Elimina un nodo específico de la lista.
     *
     * @param toDelete nodo a eliminar de la lista.
     * @return el nodo eliminado.
     */

    public DoubleNode<T> remove(DoubleNode<T> toDelete) {
        if (toDelete.prev() == null) {
            return deleteFirstNode();
        }
        if (toDelete.next() == null) {
            return deleteLastNode();
        }
        skip(toDelete);
        size--;
        return toDelete;
    }

    /**
     *
     * Salta un nodo determinado, eliminándolo de la lista.
     *
     * @param toDelete nodo a eliminar de la lista.
     */
    private void skip(DoubleNode<T> toDelete) {
        toDelete.next().prev(toDelete.prev());
        toDelete.prev().next(toDelete.next());
    }

    /**
     *
     * Busca un nodo específico en la lista.
     *
     * @param data dato a buscar en la lista.
     * @return el nodo que contiene el dato buscado, o null si el dato no se
     * encuentra en la lista.
     */
    private DoubleNode<T> search(T data) {
        DoubleNode<T> aux = head;
        if (!isEmpty()) {
            boolean stop = false;
            while ((aux != null) && (!stop)) {
                stop = (dtm().isEqual(aux.data(), data));
                aux = (stop) ? aux : aux.next();
            }
        }
        return aux;
    }

    /**
     *
     * Elimina un elemento específico de la lista.
     *
     * @param data dato a eliminar de la lista.
     * @return el nodo que contiene el dato eliminado, o null si el dato no se
     * encuentra en la lista.
     */

    private DoubleNode<T> delete(T data) {
        DoubleNode<T> found = search(data);
        if (found != null) {
            return remove(found);
        } else {
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
