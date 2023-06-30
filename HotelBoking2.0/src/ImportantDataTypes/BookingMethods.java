/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;

/**
 *
 * @author david
 */
public class BookingMethods implements DataTypeMethods<Booking>{

    @Override
    public boolean isEqual(Booking data1, Booking data2) {
        return getIdentification(data1).equals(getIdentification(data2));
    }

    @Override
    public boolean greaterThan(Booking data1, Booking data2) {
        return getIdentification(data1).compareTo(getIdentification(data2)) > 0;        
    }

    @Override
    public boolean lessThan(Booking data1, Booking data2) {
        return getIdentification(data1).compareTo(getIdentification(data2)) < 0;        
    }

    @Override
    public String toString(Booking data) {
        return "ID: "+ data.client.id+" Accommodation dates: "+data.arrivalDate+"-"+data.departureDate+" Room Type: "+ data.roomType + "\n";
    }

    @Override
    public Integer getIdentification(Booking data) {
        return data.client.id;
    }

    @Override
    public Integer getNumericalKey(Booking data) {
        return data.client.id;
    }

    @Override
    public String getStringKey(Booking data) {
        return ""+ data.client.id + data.roomType;
    }

    @Override
    public boolean isEqual(Booking data1, Integer identifier) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean greaterThan(Booking data1, Integer identifier) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean lessThan(Booking data1, Integer identifier) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEqual(Booking data1, String identifier) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean greaterThan(Booking data1, String identifier) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean lessThan(Booking data1, String identifier) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
