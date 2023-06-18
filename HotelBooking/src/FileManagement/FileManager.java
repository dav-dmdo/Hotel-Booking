/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.FileDescriptor;


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
