/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;

/**
 *
 * @author david
 */
public class Client {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String phone;

    public Client(Integer id, String firstName, String lastName, String email, String gender, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }

    public Client(String firstName, String lastName, String email, String gender, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }

    public Client(Integer id, String firstName, String lastName, String email, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }
    
    
}
