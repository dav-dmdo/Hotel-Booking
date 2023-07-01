/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import static ControllerAndRelated.BSTreeMethods.*;
import static ControllerAndRelated.DoubleLinkedListMethods.listToString;
import DS.BSTree;
import DS.DoubleLinkedList;
import DS.HashTable;
import ImportantDataTypes.Booking;
import ImportantDataTypes.Room;
import Nodes.BinaryNode;
import Nodes.DoubleNode;
import static ControllerAndRelated.BSTreeMethods.searchRoomByNumber;

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
     * Se ele
     *si successfull es 0, proceso exitoso. si es 1, no se encontro 
     * reservacion, si es 2 no se encontro habitacion disponible
     * @param id
     * @return 
     */
    public int checkIn(Integer id){
        int successfull = 0;        
        Booking booking = getBookingT(id); //debe eliminarse este booking
        if (booking== null){
            successfull = 1;
            return successfull;
        }        
        
        BinaryNode<Room> roomNode = searchRoomByType(booking.roomType);
        if (roomNode == null){
            successfull = 2;
            return successfull;
        }
        Room availableRoom = roomNode.data();
        statusHST.insert(booking);
        availableRoom.isAvailable = false;
        availableRoom.currentGuest = booking;
        
        return successfull;
    }   
    /**
     * Si successfull es 0, checkout exitoso. Si es 1, no se encontro el booking en
     * el hashtable.
     * @param key
     * @return 
     */
    public int checkOut(String key){
        int successfull = 0;
        DoubleNode<Booking> bookingNode = statusHST.delete(key);
        if(bookingNode == null){
            successfull = 1;
            return successfull;            
        }
        Booking booking = bookingNode.data();
        BinaryNode<Room> roomNode = searchRoomByNumber(roomsBSTree, booking.roomNumber); //validar sin roomNode es nulo o no
        Room room = roomNode.data();
        room.isAvailable = true;
        room.currentGuest = null;
        DoubleLinkedList<Booking> record = room.record;
        record.add(booking);
        return successfull;
    }
    

    public String getRoomRecord(Integer roomNumber){
        String recordsString = "";
        BinaryNode<Room> roomNode = searchRoomByNumber(this.roomsBSTree, roomNumber);
        if (roomNode != null){
            DoubleLinkedList<Booking> records = roomNode.data().record;
            recordsString = listToString(records);
        }
        return recordsString;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public BinaryNode<Booking> getBookingNode(Integer id){
        BinaryNode<Booking> bookingNode = searchRoomByNumber(bookingsBSTree, id);
        return bookingNode;
    }
    /**
     * 
     * @param id
     * @return Booking
     */
    public Booking getBookingT(Integer id){
        BinaryNode<Booking> bookingNode = searchRoomByNumber(bookingsBSTree, id);
        Booking booking = null;
        if(bookingNode != null)
            booking = bookingNode.data();
        return booking;
    }
    
    public String getBookingString(Integer id){
        BinaryNode<Booking> bookingNode = searchRoomByNumber(bookingsBSTree, id);
        String booking = "";
        if(bookingNode != null)
            booking = bookingsBSTree.dtm().toString(bookingNode.data());
        return booking;
    }
    
    public Booking searchGuestBooking(String key){
        Booking booking = null;
        DoubleNode<Booking> bookingNode = statusHST.search(key);
        if(bookingNode!= null)
            booking = bookingNode.data();
        return booking;        
    }
    
    public String searchGuestString(String key){
        String stringGuest = "";
        Booking guest = searchGuestBooking(key);
        if (guest == null)
            return stringGuest;        
        stringGuest += statusHST.dtm().toString(guest);
        return stringGuest;        
    }
    
    
    
    
    
    
    /**
     * Busca el room disonible por tipo de habitacion. Esto lo hace llamando a 
     * los metodos satic de la clase BSTreeMethods
     * @param roomType
     * @return 
     */
    private BinaryNode<Room> searchRoomByType(String roomType){
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
