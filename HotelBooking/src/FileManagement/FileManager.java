/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;

import DS.BinarySearchTree;
import ImportantClasses.Booking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;

import java.io.IOException;



/**
 *
 * @author david
 */
public class FileManager {
    
    final String bookingsPath = "test\\bookings.csv";
    final String roomsPath = "test\\rooms.csv";
    final String statusPath = "test\\status.csv";
    final String recordsPath = "test\\records.csv";
    
    
    public void initializeProgram(){
        this.readBookingsCSV();
        this.readRoomsCSV();
        this.readStatusCSV();
        this.readRecordsCSV();              
    }
    
    public BinarySearchTree<Booking> insertBookingsToTree(String array[], BinarySearchTree bstBooking){
        Booking booking = new Booking(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4] , array[5], array[6], array[7], array[8]);
        bstBooking.insertID(booking);
        return bstBooking;

        
    }
    public BinarySearchTree<Booking> readBookingsCSV(){
        BinarySearchTree<Booking> booking = new BinarySearchTree();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(bookingsPath)))){
      
        String line;
        String[] values; 
        br.readLine();
        while((line = br.readLine()) != null){
            values = line.split(",");  
           booking = insertBookingsToTree(values, booking); 
            
            
        }
        }catch(IOException e){
            System.out.println("Error produced while reading: "+bookingsPath+"\n"+e.getMessage());
        }         
        
        return booking;
    }
    
    public void readRoomsCSV(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(roomsPath)))){
        String line;
        String[] values; 
        br.readLine();
        while((line = br.readLine()) != null){
            values = line.split(",");           
            
        }
        }catch(IOException e){
            System.out.println("Error produced while reading: "+roomsPath+"\n"+e.getMessage());
        }  
        
    }
    public void readRoomsCSV2(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(roomsPath)))){
        String line;
        String[] values; 
        br.readLine();
        String datos="";
        while((line = br.readLine()) != null){
            datos += line;     
            
        }
        values = datos.split(",");
        
        
        }catch(IOException e){
            System.out.println("Error produced while reading: "+roomsPath+"\n"+e.getMessage());
        }  
        
    }
    public void readStatusCSV(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(statusPath)))){
        String line;
        String[] values; 
        br.readLine();
        while((line = br.readLine()) != null){
            values = line.split(",");           
            
        }
        }catch(IOException e){
            System.out.println("Error produced while reading: "+statusPath+"\n"+e.getMessage());
        }  
    }
    public void readRecordsCSV(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(recordsPath)))){
        String line;
        String[] values; 
        br.readLine();
        while((line = br.readLine()) != null){
            values = line.split(",");
            System.out.println(line);
            
        }
        }catch(IOException e){
            System.out.println("Error produced while reading: "+recordsPath+"\n"+e.getMessage());
        }  
        
    }  
    
}
