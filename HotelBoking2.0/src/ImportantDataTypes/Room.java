/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;

import DS.DoubleLinkedList;
/**
 * La clase Room representa una habitación de un hotel.
 * Contiene información como el número de la habitación, el tipo de habitación, el piso donde se encuentra, si está disponible o no, el registro de reservas y el huésped actual.
 * Puede ser creada con el número de habitación, el tipo de habitación y el piso donde se encuentra.
 */
public class Room {
    public Integer roomNumber;
    public String roomType;
    public Integer roomFloor;
    public boolean isAvailable;
    public DoubleLinkedList<Booking> record;
    public Booking currentGuest;

    /**
     * Crea una nueva instancia de Room con el número de habitación, el tipo de habitación y el piso donde se encuentra especificados.
     * @param roomNumber el número de la habitación.
     * @param roomType el tipo de habitación.
     * @param roomFloor el piso donde se encuentra la habitación.
     */
    public Room(Integer roomNumber, String roomType, Integer roomFloor) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomFloor = roomFloor;
        this.record = new DoubleLinkedList<>(new BookingMethods());
        this.isAvailable = true; // inicializado como true, luego si se encuentra en Estado, se establece en false;
        this.currentGuest = null;
    }
    
}