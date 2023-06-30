/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import static ControllerAndRelated.BSTreeMethods.search;
import static ControllerAndRelated.BSTreeMethods.*;
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
    /**
     *si successfull es 0, proceso exitoso. si es 1, no se encontro 
     * reservacion, si es 2 no se encontro habitacion disponible
     * @param id
     * @return 
     */
    public int checkIn(Integer id){
        int successfull = 0;        
        Booking booking = getBookingT(id);
        if (booking== null){
            successfull = 1;
            return successfull;
        }        
        BinaryNode<Room> roomNode = searchRoom(booking.roomType);
        if (roomNode == null){
            successfull = 2;
            return successfull;
        }
        Room availableRoom = roomNode.data();
        statusHST.insertKey(booking);
        availableRoom.isAvailable = false;
        availableRoom.currentGuest = booking;
        
        return successfull;
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
    
    
    public BinaryNode<Booking> getBookingNode(Integer id){
        BinaryNode<Booking> bookingNode = search(bookingsBSTree, id);
        return bookingNode;
    }
    
    public Booking getBookingT(Integer id){
        BinaryNode<Booking> bookingNode = search(bookingsBSTree, id);
        Booking booking = null;
        if(bookingNode != null)
            booking = bookingNode.data();
        return booking;
    }
    
    public String getBookingString(Integer id){
        BinaryNode<Booking> bookingNode = search(bookingsBSTree, id);
        String booking = "";
        if(bookingNode != null)
            booking = bookingsBSTree.dtm().toString(bookingNode.data());
        return booking;
    }
    
    private BinaryNode<Room> searchRoom(String roomType){
        BinaryNode<Room> availableRoom =null;
        switch(roomType){
            case "simple":
                availableRoom = searchAvailableSimple(roomsBSTree);
                return availableRoom;
            case "doble":
                availableRoom = searchAvailableDoble(roomsBSTree);
                return availableRoom;
            case "triple":
                availableRoom = searchAvailableTriple(roomsBSTree);
                return availableRoom;
            case "suite":
                availableRoom = searchAvailableSuite(roomsBSTree);
                return availableRoom;
                
        }
        return availableRoom;
    }
    
    
    
    
    
    
}
