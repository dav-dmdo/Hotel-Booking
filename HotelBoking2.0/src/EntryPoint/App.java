/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntryPoint;


import static ControllerAndRelated.BSTreeMethods.*;
import ControllerAndRelated.Controller;
import static ControllerAndRelated.HashTableMethods.printListsSize;
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
 * This class will initialize the entire program and call controller.
 * @author david
 */
public class App {
    FileManager fileManager;
    BSTree<Booking> bookingsBSTree;
    BSTree<Room> roomsBSTree;  
    HashTable<Booking> statusHST;
    MainGUI view;
    Controller controller;
    
    public App(){
        this.bookingsBSTree = new BSTree<>(new BookingMethods());
        this.roomsBSTree = new BSTree<>(new RoomMethods()); 
        this.statusHST = new HashTable<> (479, new BookingMethods(), true);        
        fileManager = new FileManager(this.bookingsBSTree, this.roomsBSTree, this.statusHST);
        fileManager.initializeProgram();
        this.controller = new Controller(this.bookingsBSTree, this.roomsBSTree, this.statusHST);
    }
    
    public void start(){
        MainGUI view = new MainGUI(controller);
        view.show();
        
        System.out.println("Preorder: ");
        System.out.println(preorderString(this.roomsBSTree));
        System.out.println("-------------------------------------------------");
        System.out.println("Inorder: ");
        System.out.println(inorderString(this.roomsBSTree));
        System.out.println("-------------------------------------------------");
        System.out.println("Postorder: ");
        System.out.println(inorderString(this.roomsBSTree));
        System.out.println("-------------------------------------------------");
        System.out.println("Busque en el hashtable aprox O(1): ");
        printListsSize(statusHST);       
    }
    
}
