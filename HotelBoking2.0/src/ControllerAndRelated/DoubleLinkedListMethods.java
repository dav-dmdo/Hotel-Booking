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
    
    public static<T> String listToString(DoubleLinkedList<T> list){
        String listToString = "";
        if(!list.isEmpty()){
            DoubleNode<T> aux = list.head();
            while(aux != null){
                listToString += list.dtm().toString(aux.data());
                aux = aux.next();
            }
        }        
        return listToString;
    }
}
