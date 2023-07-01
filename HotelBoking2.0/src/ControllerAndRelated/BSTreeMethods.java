/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import DS.BSTree;
import ImportantDataTypes.DataTypeMethods;
import ImportantDataTypes.Room;
import Nodes.BinaryNode;

/**
 * Esta clase proporciona metodos especificos del arbol binario de busqueda
 * que no necesariamente son replicables en todos los arboles
 * @author david
 */
public class BSTreeMethods {
    
    /**
     * @see insertBalancedFromSortedArray()
     * @param <T>
     * @param tree
     * @param array 
     */
    public static <T> void insertBalancedFromSortedArray(BSTree<T> tree, T[] array){
        insertBalancedFromSortedArray(tree,array,0,array.length-1);              
    }
    /**
     * Este metodo recibe un array de objetos ordenado de forma creciente y lo
     * utiliza para insertar en un arbol binario de busqueda, generando un arbol 
     * perfecto
     * @param <T>
     * @param tree
     * @param array
     * @param start
     * @param end 
     */
    private static <T> void insertBalancedFromSortedArray(BSTree<T> tree, T[] array, Integer start, Integer end){
        if (start > end)
            return;        
        Integer center = (start + end)/2;
        tree.insert(array[center]);        
        insertBalancedFromSortedArray(tree,array,start,center-1);      
        insertBalancedFromSortedArray(tree,array,center+1,end);          
    }
    
    /**Recibe un numero entero y lo utiliza para buscar la habitacion
     * correspondiente en el arbol de rooms
     * @see searchRoomByNumber()
     * @param <T>
     * @param tree
     * @param key
     * @return BinaryNode<T> 
     */
    
    public static <T> BinaryNode<T> searchRoomByNumber(BSTree<T> tree, Integer key){
        return searchRoomByNumber(tree.dtm(), tree.root(), key);
    }
    
    /**
     * Recibe un numero entero y lo utiliza para buscar la habitacion
     * correspondiente en el arbol de rooms
     * @param <T>
     * @param dtm
     * @param root
     * @param key
     * @return BinaryNode<T> 
     */
    private static <T> BinaryNode<T> searchRoomByNumber(DataTypeMethods<T> dtm, BinaryNode<T> root, Integer key){
        if ((root == null) || (dtm.isEqual(root.data(), key)))
            return root;        
        if(dtm.greaterThan(root.data(), key))
            return searchRoomByNumber(dtm, root.leftSon(), key);
        else
            return searchRoomByNumber(dtm, root.rightSon(), key);
    } 
    
    
    
    /**
     * Busca un room que este disponible. Si lo encuentra lo retorna,
     * sino, retorna null. El room disponible buscado debe estar entre un rango
     * de habitaciones que corresponda al tipo de habitacion buscada
     * 
     * @see searchAvailableRoom(BSTree<Room> roomTree, String roomType)
     * @param <T>
     * @param roomTree
     * @param start
     * @param stop 
     * @return BinaryNode<Room> 
     */
    private static <T> BinaryNode<Room> searchAvailableRoom(BSTree<Room> roomTree, int start, int stop){
        BinaryNode<Room> roomNode = null;
        for (int i = start; i <= stop; i++) {
            roomNode = searchRoomByNumber(roomTree.dtm(), roomTree.root(), i);
            if (roomNode.data().isAvailable){
                return roomNode;
            }            
        }
        return roomNode;
    }
    
    
    /**
     * Esta funcion se apoya de la funcion anterior  para buscar una habitacion
     * disponible del tipo especificado. Cuando se reciba un Booking, se lee el
     * tipo de habitacion y se busca una habitacion disponible que corresponda.
     * Si la encuentra, la retorna, sino retorna null.
     * @see 
     * searchAvailableSimple(BSTree<Room> roomTree)
     * searchAvailableDoble(BSTree<Room> roomTree)
     * searchAvailableTriple(BSTree<Room> roomTree)
     * searchAvailableSuite(BSTree<Room> roomTree)
     * @param <T>
     * @param roomTree
     * @param roomType
     * @return 
     */
    private static <T> BinaryNode<Room> searchAvailableRoom(BSTree<Room> roomTree, String roomType){
        BinaryNode<Room> roomNode = null;
        switch(roomType){
            case "simple":
                roomNode = searchAvailableRoom(roomTree, 1, 100);
                return roomNode;
            case "doble":
                roomNode = searchAvailableRoom(roomTree, 101, 225);
                return roomNode;
            case "triple":
                roomNode = searchAvailableRoom(roomTree, 226, 267);
                return roomNode;
            case "suite":
                roomNode = searchAvailableRoom(roomTree, 268, 300);
                return roomNode;
        }
        return roomNode;
    }
    
    /**
     * Busca una habitacion simple disponible
     * @param <T>
     * @param roomTree
     * @return 
     */
    public static <T> BinaryNode<Room> searchAvailableSimple(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "simple");
    }
    /**
     * Busca una habitacion doble disponible
     * @param <T>
     * @param roomTree
     * @return 
     */
    public static <T> BinaryNode<Room> searchAvailableDoble(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "doble");
    }
    /**
     * Busca una habitacion triple disponible
     * @param <T>
     * @param roomTree
     * @return 
     */
    public static <T> BinaryNode<Room> searchAvailableTriple(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "triple");
    }
    /**
     * Busca una habitacion suite disponible
     * @param <T>
     * @param roomTree
     * @return 
     */
    public static <T> BinaryNode<Room> searchAvailableSuite(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "suite");
    }   
    
    public static <T> String preorderString(BSTree<T> tree){
        return preorderString(tree, tree.root());
    }
    public static <T> String inorderString(BSTree<T> tree){
        return inorderString(tree, tree.root());
    }
    public static <T> String postorderString(BSTree<T> tree){
        return postorderString(tree, tree.root());
    }
    
    private static <T> String preorderString(BSTree<T> tree, BinaryNode<T> root){
        String stringTree="";        
        if (root != null){
            stringTree += tree.dtm().toString(root.data());
            stringTree += preorderString(tree, root.leftSon());            
            stringTree += preorderString(tree, root.rightSon());            
        }
        return stringTree;
    }    
    private static <T> String inorderString(BSTree<T> tree, BinaryNode<T> root){
        String stringTree="";        
        if (root != null){
            stringTree += inorderString(tree, root.leftSon());            
            stringTree += tree.dtm().toString(root.data());
            stringTree += inorderString(tree, root.rightSon());            
        }
        return stringTree;      
    }    
    private static <T> String postorderString(BSTree<T> tree, BinaryNode<T> root){
        String stringTree="";        
        if (root != null){
            stringTree += postorderString(tree, root.leftSon());            
            stringTree += postorderString(tree, root.rightSon());            
            stringTree += tree.dtm().toString(root.data());
        }
        return stringTree;        
    }
    
}
