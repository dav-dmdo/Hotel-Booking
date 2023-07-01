/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;
/**
 * La clase Booking representa una reserva de habitación en un hotel.
 * Contiene la información del cliente que realiza la reserva, el tipo y número de habitación, y las fechas de llegada y salida.
 * Puede ser creada con un objeto Client, el tipo de habitación y las fechas de llegada y salida; o con un objeto Client, el número de habitación y la fecha de salida.
 */
public class Booking {
    public Client client;
    public String roomType;
    public Integer roomNumber;
    public String arrivalDate;
    public String departureDate;
   

    /**
     * Crea una nueva instancia de Booking con el objeto Client, el tipo de habitación y las fechas de llegada y salida especificadas.
     * @param client el objeto Client que realiza la reserva.
     * @param roomType el tipo de habitación reservado.
     * @param arrivalDate la fecha de llegada a la habitación.
     * @param departureDate la fecha de salida de la habitación.
     */
    public Booking(Client client, String roomType, String arrivalDate, String departureDate) {
        this.client = client;
        this.roomType = roomType;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }
    
    /**
     * Crea una nueva instancia de Booking con el objeto Client, el número de habitación y la fecha de salida especificados.
     * @param client el objeto Client que realiza la reserva.
     * @param roomNumber el número de habitación reservado.
     * @param departureDate la fecha de salida de la habitación.
     */
    public Booking(Client client, Integer roomNumber, String departureDate) {
        this.client = client;
        this.roomNumber = roomNumber;
        this.departureDate = departureDate;
    }
       
}