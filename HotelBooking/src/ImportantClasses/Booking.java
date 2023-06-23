/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantClasses;

/**
 *
 * @author david
 */
public class Booking {
    public Client client;
    public String roomType;
    public String arrivalDate;
    public String departureDate;
    
    public Booking(Client client, String roomType, String arrivalDate, String departureDate){
        this.client = client;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.roomType = roomType;
    }
    
}
