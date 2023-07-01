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
 *
 * @author david
 */
public class BSTreeMethods {
    
    
    public static <T> void insertBalancedFromSortedArray(BSTree<T> tree, T[] array){
        insertBalancedFromSortedArray(tree,array,0,array.length-1);              
    }
    
    private static <T> void insertBalancedFromSortedArray(BSTree<T> tree, T[] array, Integer start, Integer end){
        if (start > end)
            return;        
        Integer center = (start + end)/2;
        tree.insert(array[center]);        
        insertBalancedFromSortedArray(tree,array,start,center-1);      
        insertBalancedFromSortedArray(tree,array,center+1,end);          
    }
    
    public static <T> BinaryNode<T> searchRoomByNumber(BSTree<T> tree, Integer key){
        return searchRoomByNumber(tree.dtm(), tree.root(), key);
    }
    
    private static <T> BinaryNode<T> searchRoomByNumber(DataTypeMethods<T> dtm, BinaryNode<T> root, Integer key){
        if ((root == null) || (dtm.isEqual(root.data(), key)))
            return root;        
        if(dtm.greaterThan(root.data(), key))
            return searchRoomByNumber(dtm, root.leftSon(), key);
        else
            return searchRoomByNumber(dtm, root.rightSon(), key);
    } 
    /**
     * Busca un room Simple que este disponible. Si lo encuentra lo retorna,
     * sino, retorna null
     * @param <T>
     * @param roomTree
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
    
    public static <T> BinaryNode<Room> searchAvailableSimple(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "simple");
    }
    public static <T> BinaryNode<Room> searchAvailableDoble(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "doble");
    }
    public static <T> BinaryNode<Room> searchAvailableTriple(BSTree<Room> roomTree){
        return searchAvailableRoom(roomTree, "triple");
    }
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
    
    
    
//    public static <T> BinaryNode<T> deleteNode(BSTree<T> tree, Integer key) {
//        return deleteNode(tree.root(), key, tree.dtm());
//    }
//    public static <T> BinaryNode<T> deleteNode(BinaryNode<T> root, T key, DataTypeMethods<T> dtm, BSTree<T> tree) {
//        if (root == null) {
//            return root;
//        }
//        if (dtm.lessThan(root.data(), key)) {
//            root.rightSon((deleteNode(root.rightSon(), key, dtm,tree)));
//        } else if (dtm.greaterThan(root.data(), key)) {
//            root.leftSon(deleteNode(root.leftSon(), key, dtm,tree));
//        } else {
//            if (root.isLeaf()) {
//                root = null;
//            } else if (root.rightSon() != null) {
//                root.data(searchParentForInsertion(tree.root(), key));
//                root.setRight(deleteNode(root.getRight(), root.getData().id));
//            } else {
//                root.setData(previousBooking(root).getData());
//                root.setLeft(deleteNode(root.getLeft(), root.getData().id));
//            }
//        }
//        return root;
//    }
    
}
