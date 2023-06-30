/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntryPoint;

import DS.BSTree;
import DS.HashTable;
import FileManagement.FileManager;
import ImportantDataTypes.Booking;
import ImportantDataTypes.BookingMethods;
import ImportantDataTypes.Client;
import ImportantDataTypes.ClientMethods;
import ImportantDataTypes.Room;
import ImportantDataTypes.RoomMethods;

/**
 *
 * @author david
 */
public class App {
    FileManager fileManager;
    BSTree<Booking> bookingsBSTree;
    BSTree<Room> roomsBSTree;  
    HashTable<Client> hstStatus;
    
    public App(){
        this.bookingsBSTree = new BSTree<>(new BookingMethods());
        this.roomsBSTree = new BSTree<>(new RoomMethods()); 
        //this.hstStatus = new HashTable<> (477, new ClientMethods(), true);
    }
    
    public void start(){
        fileManager = new FileManager(bookingsBSTree, roomsBSTree);
        fileManager.initializeProgram();

        System.out.println(this.bookingsBSTree.preorder());
        System.out.println("---------");
        System.out.println(this.bookingsBSTree.dtm().toString(this.bookingsBSTree.root().data()));
        System.out.println("---------");
        System.out.println(this.roomsBSTree.preorder());
    }
    
}
