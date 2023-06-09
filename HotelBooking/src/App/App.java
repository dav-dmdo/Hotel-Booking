/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;


import DS.BSTree;
import DS.BinarySearchTree;
import DS.HashTable;
import DS.Lista;
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
    BinarySearchTree historical;
    HashTable htStatus;

    public App() {
        this.main = null;
        this.bstBooking = null;
        this.historical = null ;
        this.htStatus= null;
    }

    //Methods

    public void showMenu() {

        this.bstBooking = file.readBookingsCSV();
        this.historical = file.readRecordsCSV();
        this.htStatus = file.readStatusCSV();
        this.main = new MainGUI(bstBooking, historical, htStatus);

        main.show();
    }

}
