/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;


import static ControllerAndRelated.BSTreeMethods.insertBalancedFromSortedArray;
import DS.BSTree;
import DS.DoubleLinkedList;
import DS.HashTable;
import ImportantDataTypes.Booking;
import ImportantDataTypes.Client;
import ImportantDataTypes.Room;
import Nodes.BinaryNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static ControllerAndRelated.BSTreeMethods.searchRoomByNumber;

/**
 *
 * @author david
 */
public class FileManager {
    final String bookingsPath = "test\\bookings.csv";
    final String statusPath = "test\\status.csv";
    final String recordsPath = "test\\records.csv";
    final String roomsPath = "test\\rooms.csv";
    
    private final HashTable<Booking> statusHST;
    private final BSTree<Booking> bookingsBSTree;
    private final BSTree<Room> roomsBSTree;
    
    private final Room[] roomsArray = new Room[300];
    public int roomsCounter = 0;

    public FileManager(BSTree<Booking> bookingsBSTree, BSTree<Room> roomsBSTree, HashTable<Booking> statusHST) {
        this.bookingsBSTree = bookingsBSTree;
        this.roomsBSTree = roomsBSTree;
        this.statusHST = statusHST;
    }
    
    /**
     * Inicializo el programa llamando a todas las funciones vinculadas
     * con la lectura de archivos y la carga de la informacion en
     * las estructuras de datos. Sigue un orden especifico de ejecucion importante
     * para garantizar que no se generen excepciones.
     */
    public void initializeProgram(){
        this.readRoomsCSV();
        insertBalancedFromSortedArray(roomsBSTree, roomsArray);
        this.readBookingsCSV();
        this.readStatusCSV();
        this.readRecordsCSV();
    }
    
    /**
     * Llama al metodo general de lectura de CSV y le pasa por parametro
     * un el path del archivo correspondiente (roomsPath)
     */
    private void readRoomsCSV(){
        readCSVToApplyProcess(roomsPath);        
    }
    
    /**
     * Llama al metodo general de lectura de CSV y le pasa por parametro
     * un el path del archivo correspondiente (bookingsPath)
     */
    private void readBookingsCSV(){
        readCSVToApplyProcess(bookingsPath);
    }
    /**
     * Llama al metodo general de lectura de CSV y le pasa por parametro
     * un el path del archivo correspondiente (statusPath)
     */
    private void readStatusCSV(){
        readCSVToApplyProcess(statusPath);        
    }
    /**
     * Llama al metodo general de lectura de CSV y le pasa por parametro
     * un el path del archivo correspondiente (recordsPath)
     */
    private void readRecordsCSV(){
        readCSVToApplyProcess(recordsPath);        
    }
    
    /**
     * Metodo general de lectura de arcchivos que recibe una ruta y
     * llama a una funcion del tipo Switch que actura de una forma especififca
     * dependiendo del valor del string path.
     * @param path 
     */
    private void readCSVToApplyProcess(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            String[] values;
            br.readLine();
            while ((line = br.readLine()) != null) {
                values = line.split(",");
                chooseProcess(path, values);                
            }
        } catch (IOException e) {
            System.out.println("Error produced while reading: " + path + "\n" + e.getMessage());
        }
    }
    
    /**
     * elige el proceso correspondiente al archivo que se este leyendo
     * @param path
     * @param values 
     */
    private void chooseProcess(String path, String[] values){
        
        switch(path){
            
            case "test\\bookings.csv":
                bookingProcess(values);
                break;
            case "test\\status.csv":
                statusProcess(values);
                break;
            case "test\\records.csv":
                recordsProcess(values);
                break;
            case "test\\rooms.csv":
                roomsProcess(values);
                break;                
        }       
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////ROOMS////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////    
    /**
     * Almaceno en el atributo roomsArray de la clase, luego aumento el contador.
     * @param values 
     */
    private void roomsProcess(String[] values){
       Room room = createRoomFromArray(values);
       roomsArray[roomsCounter++] = room;        
    }
    /**
     * Creo y retorno instancia de la clase room
     * @param values
     * @return 
     */
    private Room createRoomFromArray(String[] values){
        Integer roomNumber = Integer.valueOf(values[0].trim());
        String roomType = values[1].trim();
        Integer roomFloor = Integer.valueOf(values[2].trim());
        return new Room(roomNumber, roomType, roomFloor) ;      
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////BOOKINGS/////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////     
    /**
     * Inserto en el arbol la instancia de Booking
     * @param values 
     */
    private void bookingProcess(String[] values){
        Booking booking = createBookingFromBookingArray(values);
        this.bookingsBSTree.insert(booking);        
    }
    /**
     * Creo y retorno una instancia de Booking
     * @param values
     * @return 
     */    
    private Booking createBookingFromBookingArray(String[] values){
        Integer ci = Integer.valueOf(values[0].trim());
        String firstName = values[1].trim();
        String lastName = values[2].trim();
        String email = values[3].trim();
        String gender =values[4].trim();
        String phone =values[6].trim();        
        
        Client client = new Client(ci, firstName, lastName, email, gender, phone);
        
        String roomType = values[5].trim();
        String arrivalDate = values[7].trim();
        String departureDate = values[8].trim();
        
        return new Booking(client, roomType, arrivalDate, departureDate);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////STATUS///////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////// 
    /**
     * Inerto en el HashTable la instancia de Booking si es que esta no es nula.
     * @param values 
     */
    private void statusProcess(String[] values){
        Booking booking = createBookingFromStatusArray(values);
        if(booking != null)
            statusHST.insert(booking);
    }
    /**
     * Creo y retorno una instancia de la clase booking. Si el numemero de
     * habitacion en el arreglo es vacio "", retorna nulo indicando.
     * Si el numero es diferente a vacio, busco la habitacion en el arbol binario
     * de busqueda correspondiente a las habitaciones. Encuentro la habitacion
     * y la marco como no disponible.
     * 
     * Creo la instancia de booking con los datos correspondientes.
     * A la habitacion le asigno el cliente que esta hospedado(el booking).
     * 
     * retorno el booking.
     * @param values
     * @return Booking
     */
    private Booking createBookingFromStatusArray(String[] values){
        Booking booking = null;
        String roomNumberString = values[0];
        if (roomNumberString.isEmpty())
            return booking;
        Integer roomNumber = Integer.valueOf(roomNumberString);
        BinaryNode<Room> room = searchRoomByNumber(roomsBSTree, roomNumber);
        if(room != null) //nunca es null. Si el clinte esta hospedado, la habitacion existe.
            room.data().isAvailable = false;  //la seteo a no disponible.
        
        String firstName = values[1].trim();
        String lastName = values[2].trim();
        String email = values[3].trim();
        String gender =values[4].trim();
        String phone =values[5].trim();        
        
        Client client = new Client( firstName, lastName, email, gender, phone);
        String roomType = getRoomType(roomNumber);
        
        String date =values[6].trim();        
        booking = new Booking(client, roomType, roomNumber, date);
        room.data().currentGuest = booking;        // possible null pointer
        return booking;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////RECORDS//////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////// 
    /**
     * Recibo la instancia de booking, busco la habitacion correspondiente al
     * atributo roomumber del Booking, si la consigo (siempre debe conseguirse),
     * agrego al atributo record(lista doblemente enlazada) de la habitacion la 
     * instancia de booking.
     * 
     * @param values 
     */
    private void recordsProcess(String[] values){
        Booking booking = createBookingFromRecordArray(values);
        BinaryNode<Room> roomNode = searchRoomByNumber(roomsBSTree, booking.roomNumber);
        if (roomNode != null){
            Room room = roomNode.data();
            DoubleLinkedList<Booking> record = room.record;
            record.add(booking);
        }        
    }
    /**
     * Creo un Booking y lo retorno
     * @param values
     * @return 
     */
    private Booking createBookingFromRecordArray(String[] values){
        Integer ci = Integer.valueOf(values[0].trim());
        String firstName = values[1].trim();
        String lastName = values[2].trim();
        String email = values[3].trim();
        String gender =values[4].trim();
        
        Client client = new Client(ci, firstName, lastName, email, gender);
        
        String date =values[5].trim();
        Integer roomNumber = Integer.valueOf(values[6].trim());
        String roomType = getRoomType(roomNumber);
        
        return new Booking(client, roomType, roomNumber, date);        
    }
    
    ///////////////////////////////////////////////////////////////////////////

    private String getRoomType(Integer roomNumber){
        String roomType = "";
        if ((1<= roomNumber)&&(roomNumber<= 100))
            roomType = "simple";
        else if ((101<= roomNumber)&&(roomNumber<= 225))
            roomType = "doble";
        else if ((226<= roomNumber)&&(roomNumber<= 267))
            roomType = "triple";
        else if ((268<= roomNumber)&&(roomNumber<= 300))
            roomType = "suite";
        return roomType;        
    }
}
