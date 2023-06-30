/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;


import DS.BSTree;
import ImportantDataTypes.Booking;
import ImportantDataTypes.Client;
import ImportantDataTypes.Room;
import Nodes.BinaryNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author david
 */
public class FileManager {
    final String bookingsPath = "test\\bookings.csv";
    final String statusPath = "test\\status.csv";
    final String recordsPath = "test\\records.csv";
    final String roomsPath = "test\\rooms.csv";
    
    //private HashTable statusHashTable;
    private BSTree<Booking> bookingsBSTree;
    private BSTree<Room> roomsBSTree;
    
    public FileManager(){
        
    }

    public FileManager(BSTree<Booking> bookingsBSTree, BSTree<Room> roomsBSTree) {
        this.bookingsBSTree = bookingsBSTree;
        this.roomsBSTree = roomsBSTree;
    }
    
    
    public void initializeProgram(){
        //this.readStatusCSV();
        this.readRoomsCSV();
        this.readBookingsCSV();
        //this.readRecordsCSV();
    }
    
    private void readBookingsCSV(){
        readCSVToApplyProcess(bookingsPath);
    }
    private void readStatusCSV(){
        readCSVToApplyProcess(statusPath);        
    }
    private void readRoomsCSV(){
        readCSVToApplyProcess(roomsPath);        
    }
    private void readRecordsCSV(){
        readCSVToApplyProcess(recordsPath);        
    }
    
    private void readCSVToApplyProcess(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            String[] values;
            br.readLine();
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                chooseProcess(path, values);                
            }
        } catch (IOException e) {
            System.out.println("Error produced while reading: " + path + "\n" + e.getMessage());
        }
    }
    
    
    private void chooseProcess(String path, String[] values){
        
        switch(path){
            
            case "test\\bookings.csv":
                bookingProcess(values);
                break;
            case "test\\status.csv":
                statusProcess(values);
                break;
            case "test\\records.csv":
                recordsProcess(values);
                break;
            case "test\\rooms.csv":
                roomsProcess(values);
                break;                
        }       
    }
    
    private void bookingProcess(String[] values){
        Booking booking = createBookingFromArray(values);
        this.bookingsBSTree.add(booking);        
        
    }
    private void statusProcess(String[] values){
        Integer roomNumber = Integer.valueOf(values[0]);
        BinaryNode<Room> room = this.roomsBSTree.SearchRoom(roomNumber);
        if(room != null)
            room.data().isAvailable = false;
        
        Integer ci = Integer.valueOf(values[0].trim());
        String firstName = values[1].trim();
        String lastName = values[2].trim();
        String email = values[3].trim();
        String gender =values[4].trim();
        String phone =values[6].trim();        
        
        Client client = new Client(ci, firstName, lastName, email, gender, phone);
        
        
    }
    private void recordsProcess(String[] values){
        Integer ci = Integer.valueOf(values[0].trim());
        String firstName = values[1].trim();
        String lastName = values[2].trim();
        String email = values[3].trim();
        String gender =values[4].trim();
        String phone =values[6].trim();        
        
        Client client = new Client(ci, firstName, lastName, email, gender, phone);
        
    }
    private void roomsProcess(String[] values){
       Room room = createRoomFromArray(values);
        this.roomsBSTree.add(room);        
    }
    
    
    
    
    private Booking createBookingFromArray(String[] values){
        Integer ci = Integer.valueOf(values[0].trim());
        String firstName = values[1].trim();
        String lastName = values[2].trim();
        String email = values[3].trim();
        String gender =values[4].trim();
        String phone =values[6].trim();        
        
        Client client = new Client(ci, firstName, lastName, email, gender, phone);
        
        String roomType = values[5].trim();
        String arrivalDate = values[7].trim();
        String departureDate = values[8].trim();
        
        return new Booking(client, roomType, arrivalDate, departureDate);
    }
    
    private Room createRoomFromArray(String[] values){
        Integer roomNumber = Integer.valueOf(values[0].trim());
        String roomType = values[1].trim();
        Integer roomFloor = Integer.valueOf(values[2].trim());
        return new Room(roomNumber, roomType, roomFloor) ;      
    }
      
}
