/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import DS.DoubleLinkedList;
import Nodes.DoubleNode;
/**
 * La clase DoubleLinkedListMethods proporciona métodos estáticos para realizar operaciones en una lista doblemente enlazada.
 */
public class DoubleLinkedListMethods {

    /**
     * Convierte la lista doblemente enlazada a una cadena de texto.
     * @param <T>
     * @param list la lista doblemente enlazada a convertir.
     * @return una cadena de texto que representa a la lista doblemente enlazada.
     */

    public static <T> String listToString(DoubleLinkedList<T> list) {
        String listToString = "";
        if (!list.isEmpty()) {
            DoubleNode<T> aux = list.head();
            while (aux != null) {
                listToString += list.dtm().toString(aux.data());
                aux = aux.next();
            }
        }
        return listToString;
    }

    /**
     * Busca un elemento en la lista doblemente enlazada cuya clave es una cadena de texto.
     * @param list la lista doblemente enlazada donde se realizará la búsqueda.
     * @param <T>
     * @param key la clave de búsqueda.
     * @return el nodo que contiene el elemento si se encuentra, o null en caso contrario.
     */

    public static <T> DoubleNode<T> searchStringKey(DoubleLinkedList<T> list, String key) {
        DoubleNode<T> aux = list.head();
        if (!list.isEmpty()) {
            boolean stop = false;
            while ((aux != null) && (!stop)) {
                stop = (list.dtm().isEqual(aux.data(), key));
                aux = (stop) ? aux : aux.next();
            }
        }
        return aux;
    }

    /**
     * Busca un elemento en la lista doblemente enlazada cuya clave es un número entero.
     * @param <T>
     * @param list la lista doblemente enlazada donde se realizará la búsqueda.
     * @param key la clave de búsqueda.
     * @return el nodo que contiene el elemento si se encuentra, o null en caso contrario.
     */
    public static <T> DoubleNode<T> searchIntegerKey(DoubleLinkedList<T> list, Integer key) {
        DoubleNode<T> aux = list.head();
        if (!list.isEmpty()) {
            boolean stop = false;
            while ((aux != null) && (!stop)) {
                stop = (list.dtm().isEqual(aux.data(), key));
                aux = (stop) ? aux : aux.next();
            }
        }
        return aux;
    }

    /**
     * Elimina un elemento de la lista doblemente enlazada cuya clave es una cadena de texto.
     * @param <T>
     * @param list la lista doblemente enlazada donde se realizará la eliminación.
     * @param key la clave de búsqueda del elemento a eliminar.
     * @return el nodo que contiene el elemento eliminado si se encuentra, o null en caso contrario.
     */
    public static <T> DoubleNode<T> deleteByStringKey(DoubleLinkedList<T> list, String key) {
        DoubleNode<T> found = searchStringKey(list, key);
        if (found != null) {
            return list.remove(found);
        } else {
            return null;
        }
    }
}