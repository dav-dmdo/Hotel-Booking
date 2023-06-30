/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import static ControllerAndRelated.BSTreeMethods.search;
import static ControllerAndRelated.DoubleLinkedListMethods.listToString;
import DS.BSTree;
import DS.DoubleLinkedList;
import DS.HashTable;
import ImportantDataTypes.Booking;
import ImportantDataTypes.Room;
import Nodes.BinaryNode;

/**
 *
 * @author david
 */
public class Controller {
    BSTree<Booking> bookingsBSTree;
    BSTree<Room> roomsBSTree;
    HashTable<Booking> statusHST;

    public Controller(BSTree<Booking> bookingsBSTree, BSTree<Room> roomsBSTree, HashTable<Booking> statusHST) {
        this.bookingsBSTree = bookingsBSTree;
        this.roomsBSTree = roomsBSTree;
        this.statusHST = statusHST;
    }

    public String getRoomRecord(Integer roomNumber){
        String recordsString = "";
        BinaryNode<Room> roomNode = search(this.roomsBSTree, roomNumber);
        if (roomNode != null){
            DoubleLinkedList<Booking> records = roomNode.data().record;
            recordsString = listToString(records);
        }
        return recordsString;
    }
    
    
    
    
}
