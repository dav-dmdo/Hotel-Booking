/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;

import DS.BinarySearchTree;
import DS.HashTable;
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
    
    public HashTable guests;
    public BinarySearchTree rooms;
    public BinarySearchTree bookings;
    
    public FileManager(HashTable guests, BinarySearchTree rooms, BinarySearchTree bookings ){
        this.guests = guests;
        this.rooms = rooms;
        this.bookings = bookings;
    }
    
    public void initializeProgram(){
        this.readBookingsCSV();
        this.readRoomsCSV();
        this.readStatusCSV();
        this.readRecordsCSV();              
    }
    
    public void readBookingsCSV(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(bookingsPath)))){
        String line;
        String[] values; 
        br.readLine();
        while((line = br.readLine()) != null){
            values = line.split(",");           
            
        }
        }catch(IOException e){
            System.out.println("Error produced while reading: "+bookingsPath+"\n"+e.getMessage());
        }         
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
