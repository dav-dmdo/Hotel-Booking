/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import static ControllerAndRelated.DoubleLinkedListMethods.searchStringKey;
import DS.DoubleLinkedList;
import DS.HashTable;
import ImportantDataTypes.Booking;
import Nodes.DoubleNode;

/**
 *
 * @author david
 */
public class HashTableMethods {
    public static <T> void printListsSize(HashTable<T> hashTable){
        for (DoubleLinkedList<T> list : hashTable.table) {
            System.out.println(list.size());
        }
        
    }
}
