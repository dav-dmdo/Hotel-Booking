/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntryPoint;

import static ControllerAndRelated.BSTreeMethods.inorderString;
import static ControllerAndRelated.BSTreeMethods.postorderString;
import static ControllerAndRelated.BSTreeMethods.preorderString;
import static ControllerAndRelated.BSTreeMethods.*;
import ControllerAndRelated.Controller;
import DS.BSTree;
import DS.HashTable;
import FileManagement.FileManager;
import GUIS.MainGUI;
import ImportantDataTypes.Booking;
import ImportantDataTypes.BookingMethods;
import ImportantDataTypes.Client;
import ImportantDataTypes.ClientMethods;
import ImportantDataTypes.Room;
import ImportantDataTypes.RoomMethods;
import Nodes.BinaryNode;

/**
 *
 * @author david
 */
public class App {
    FileManager fileManager;
    BSTree<Booking> bookingsBSTree;
    BSTree<Room> roomsBSTree;  
    HashTable<Booking> hstStatus;
    MainGUI view;
    Controller controller;
    
    public App(){
        this.bookingsBSTree = new BSTree<>(new BookingMethods());
        this.roomsBSTree = new BSTree<>(new RoomMethods()); 
        this.hstStatus = new HashTable<> (479, new BookingMethods(), true);        
        fileManager = new FileManager(bookingsBSTree, roomsBSTree);
        fileManager.initializeProgram();
        this.controller = new Controller(this.bookingsBSTree, this.roomsBSTree, this.hstStatus);
    }
    
    public void start(){
        MainGUI view = new MainGUI(bookingsBSTree, roomsBSTree, hstStatus);
        view.show();
        System.out.println(controller.checkIn(12902463));
        
    }
    
}
