/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import DS.DoubleLinkedList;
import Nodes.DoubleNode;

/**
 *
 * @author david
 */
public class DoubleLinkedListMethods {

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

    public static <T> DoubleNode<T> deleteByStringKey(DoubleLinkedList<T> list, String key) {
        DoubleNode<T> found = searchStringKey(list, key);
        if (found != null) {
            return list.remove(found);
        } else {
            return null;
        }
    }
}
