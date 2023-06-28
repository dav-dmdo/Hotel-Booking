/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;

import DS.BSTree;
import DS.BinarySearchTree;
import DS.HashTable;
import DS.Lista;
import DS.ListNode;
import ImportantClasses.Booking;
import ImportantClasses.BookingMethods;
import ImportantClasses.Historical;
import ImportantClasses.Person;
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
    final String statusPath = "test\\status.csv";
    final String recordsPath = "test\\records.csv";

    public HashTable guests;
    public BinarySearchTree rooms;
    public BinarySearchTree bookings;

    private BinarySearchTree<Booking> insertBookingsToTree(String array[], BinarySearchTree bstBooking) {
        Booking booking = new Booking(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
        bstBooking.insertID(booking);
        return bstBooking;

    }

    public BinarySearchTree<Booking> readBookingsCSV() {
        BinarySearchTree<Booking> booking = new BinarySearchTree();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(bookingsPath)))) {

            String line;
            String[] values;
            br.readLine();
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                booking = insertBookingsToTree(values, booking);

            }
        } catch (IOException e) {
            System.out.println("Error produced while reading: " + bookingsPath + "\n" + e.getMessage());
        }

        return booking;
    }


    public HashTable readStatusCSV() {
        HashTable hsTGuests = new HashTable(1000);

        try (BufferedReader br = new BufferedReader(new FileReader(new File(statusPath)))) {
            String line;
            String[] values;
            br.readLine();
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                insertGuests(values, hsTGuests);
            }
        } catch (IOException e) {
            System.out.println("Error produced while reading: " + statusPath + "\n" + e.getMessage());
        }
        return hsTGuests;
    }

    private void insertGuests(String array[], HashTable hsTGuests) {
        if(!array[0].isBlank()){
            Object key = array[1].trim()+" "+array[2].trim();
            Object value = array[0].trim();
            hsTGuests.insert(key,value);            
        }
    }

    private BinarySearchTree<Historical> insertrecords(String array[], BinarySearchTree bstBooking) {
        Person p = new Person(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5]);

        Lista l = new Lista();
        l.addFirst(p);
        //System.out.println(l.printListPerson(l));
        Historical history = new Historical(l, Integer.parseInt(array[6]));
        bstBooking.insertRoom(history);

        return bstBooking;

    }

    public BinarySearchTree<Historical> readRecordsCSV() {
        BinarySearchTree bst = new BinarySearchTree();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(recordsPath)))) {

            String line;
            String[] values;
            br.readLine();
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                bst = insertrecords(values, bst);
                //System.out.println(line);

            }
        } catch (IOException e) {
            System.out.println("Error produced while reading: " + recordsPath + "\n" + e.getMessage());
        }

        return bst;
    }

}
