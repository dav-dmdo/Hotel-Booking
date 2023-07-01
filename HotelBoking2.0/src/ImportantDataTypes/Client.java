/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;
/**
 * La clase Client representa a un cliente que realiza una reserva en un hotel.
 * Contiene información como el identificador del cliente, su nombre, apellido, correo electrónico, género y número de teléfono.
 * Puede ser creada con un identificador, nombre, apellido, correo electrónico, género y número de teléfono; o con nombre, apellido, correo electrónico y género.
 */
public class Client {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String phone;

    /**
     * Crea una nueva instancia de Client con el identificador, nombre, apellido, correo electrónico, género y número de teléfono especificados.
     * @param id el identificador del cliente.
     * @param firstName el nombre del cliente.
     * @param lastName el apellido del cliente.
     * @param email el correo electrónico del cliente.
     * @param gender el género del cliente.
     * @param phone el número de teléfono del cliente.
     */
    public Client(Integer id, String firstName, String lastName, String email, String gender, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }

    /**
     * Crea una nueva instancia de Client con el nombre, apellido, correo electrónico y género especificados.
     * @param firstName el nombre del cliente.
     * @param lastName el apellido del cliente.
     * @param email el correo electrónico del cliente.
     * @param gender el género del cliente.
     * @param phone el número de teléfono del cliente.
     */
    public Client(String firstName, String lastName, String email, String gender, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
    }

    /**
     * Crea una nueva instancia de Client con el identificador, nombre, apellido, correo electrónico y género especificados.
     * @param id el identificador del cliente.
     * @param firstName el nombre del cliente.
     * @param lastName el apellido del cliente.
     * @param email el correo electrónico del cliente.
     * @param gender el género del cliente.
     */
    public Client(Integer id, String firstName, String lastName, String email, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }
    
    
}