/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantClasses;

/**
 *
 * @author david
 */
public class Person {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    //public String phoneNumber;
    public String arrival;
    
    public Person(Integer id, String firstName, String lastName, String email, String gender, String phoneNumber, String arrival){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.arrival = arrival;
       // this.phoneNumber = phoneNumber;
    }

    
    
}
