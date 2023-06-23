/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantClasses;

import Interfaces.DataTypeMethods;

/**
 *
 * @author david
 */
public class BookingMethods implements DataTypeMethods <Booking> {

    @Override
    public boolean isEqual(Booking data1, Booking data2) {
        return getKey(data1).equals(getKey(data2));
    }

    @Override
    public boolean greaterThan(Booking data1, Booking data2) {
        return getKey(data1).compareTo(getKey(data2)) > 0;
    }

    @Override
    public boolean lessThan(Booking data1, Booking data2) {
        return getKey(data1).compareTo(getKey(data2)) < 0;
    }

    @Override
    public String toString(Booking data) {
        return "ID: " + data.id + "\nNAME: " + data.firstName + " " + data.lastName + "\nEMAIL: " + data.email + "\nGENRE: " + data.gender + "\nPHONE NUMBER: " + data.phoneNumber + "\nARRIVAL: " + data.arrivalDate + "\nDEPARTURE DATE: " + data.departureDate + "\n\n";
    }

    @Override
    public Integer getKey(Booking data) {
        return data.id;        
    }
    
}
