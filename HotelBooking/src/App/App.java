/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DS.BinarySearchTree;
import FileManagement.FileManager;
import GUIS.MainGUI;
import ImportantClasses.Booking;

/**
 *
 * @author david
 */
public class App {
    //Atributos
    MainGUI main;
    BinarySearchTree bstBooking;
    FileManager file = new FileManager();

    public App() {
        this.main = null;
        this.bstBooking =  new BinarySearchTree();
    }
    
    
   
    
    //Methods
    public void showMenu(){
    
    this.bstBooking= file.readBookingsCSV();
    this.main = new MainGUI(bstBooking);
    main.show();}
}
