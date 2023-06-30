/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImportantDataTypes;

/**
 *
 * @author david
 */
public class RoomMethods implements DataTypeMethods<Room>{

    @Override
    public boolean isEqual(Room data1, Room data2) {
        return getIdentification(data1).equals(getIdentification(data2));
    }

    @Override
    public boolean greaterThan(Room data1, Room data2) {
        return getIdentification(data1).compareTo(getIdentification(data2)) > 0;
    }

    @Override
    public boolean lessThan(Room data1, Room data2) {
        return getIdentification(data1).compareTo(getIdentification(data2)) < 0;        
    }

    @Override
    public String toString(Room data) {
        return "Number: "+ data.roomNumber+" Type: "+ data.roomType +" Floor: " +data.roomFloor+"\n";
    }

    @Override
    public Integer getIdentification(Room data) {
        return data.roomNumber;
    }

    @Override
    public Integer getNumericalKey(Room data) {
        return data.roomNumber;
    }

    @Override
    public String getStringKey(Room data) {
        return data.roomNumber + data.roomType + data.roomFloor;
    }
    
}
