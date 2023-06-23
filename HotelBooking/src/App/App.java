/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DS.BinarySearchTree;
import DS.HashTable;
import FileManagement.FileManager;
import GUIS.MainGUI;
import ImportantClasses.Booking;
import ImportantClasses.Client;
import ImportantClasses.Room;

/**
 *
 * @author david
 */
public class App {
    //Atributos
    MainGUI menu = new MainGUI();
    
    //Methods
    public void showMenu(){
    menu.show();}
    
    public void start(){
        BinarySearchTree<Booking> bookings = new BinarySearchTree<>();
        BinarySearchTree<Room> rooms = new BinarySearchTree<>();
        HashTable guests = new HashTable(347);
        
        FileManager fm = new FileManager(guests, rooms, bookings);
        
        fm.initializeProgram();
        
    }
        
}
