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
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String phoneNumber;
    public String arrivalDate;
    public String departureDate;
    
    public Booking(int id, String firstName, String lastName, String email, String gender, String phoneNumber, String arrivalDate, String departureDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }
    
}
