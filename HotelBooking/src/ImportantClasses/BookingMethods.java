/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantClasses;

import DS.NodeABB;
import Interfaces.DataTypeMethods;

/**
 *
 * @author david
 */
public class BookingMethods implements DataTypeMethods <NodeABB> {

    @Override
    public boolean isEqual(int data1, NodeABB data2) {
        return data1== (getKey(data2));
    }

    @Override
    public boolean greaterThan(int data1, NodeABB data2) {
        return data1 >(getKey(data2));
    }

    @Override
    public boolean lessThan(int data1, NodeABB data2) {
        return data1<getKey(data2);
    }

    @Override
    public String toString(NodeABB datas) {
        NodeABB<Booking> nodes = datas;
        Booking data= nodes.getData();
        return "ID: " + data.id + "\nNAME: " + data.firstName + " " + data.lastName + "\nEMAIL: " + data.email + "\nGENRE: " + data.gender + "\nPHONE NUMBER: " + data.phoneNumber + "\nARRIVAL: " + data.arrivalDate + "\nDEPARTURE DATE: " + data.departureDate + "\n\n";
    }

    @Override
    public Integer getKey(NodeABB node) {
        NodeABB<Booking> nodes = node;
        return nodes.getData().id;        
    }
    
}
