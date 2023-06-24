/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DS.BSTree;
import DS.BinarySearchTree;
import DS.List;
import FileManagement.FileManager;
import GUIS.MainGUI;
import ImportantClasses.Booking;
import ImportantClasses.BookingMethods;

/**
 *
 * @author david
 */
public class App {
    //Atributos
    MainGUI main;
     BinarySearchTree bstBooking;
    FileManager file = new FileManager();
    List list = new List();
    BinarySearchTree historical;

    public App() {
        this.main = null;
        BookingMethods bm = new BookingMethods();
        this.bstBooking =  new  BinarySearchTree();
this.historical = new BinarySearchTree();
    }
    
    
   
    
    //Methods
    public void showMenu(){
   
    
    this.bstBooking= file.readBookingsCSV();
    this.historical = file.readRecordsCSV();
    this.main = new MainGUI(bstBooking, historical);
    
    main.show();}

        


    }

