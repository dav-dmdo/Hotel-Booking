/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;

import DS.DoubleLinkedList;

/**
 *
 * @author david
 */
public class Room {
    public Integer roomNumber;
    public String roomType;
    public Integer roomFloor;
    public boolean isAvailable;
    public DoubleLinkedList<Client> record;

    public Room(Integer roomNumber, String roomType, Integer roomFloor) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
        this.record = new DoubleLinkedList<>(new ClientMethods());
        this.isAvailable = true; // initialized as false, then if found in Status, set to true;
    }    
  
    public void insertarClienteenRecord(Client client){
    }
    
}
