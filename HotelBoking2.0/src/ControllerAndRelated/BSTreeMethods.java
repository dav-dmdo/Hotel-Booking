/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerAndRelated;

import DS.BSTree;
import ImportantDataTypes.DataTypeMethods;
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
        T toAdd = array[center];
        insertBalancedFromSortedArray(tree,array,start,center-1);      
        insertBalancedFromSortedArray(tree,array,center+1,end);          
        tree.insert(toAdd);        
    }
    
    public static <T> BinaryNode<T> search(BSTree<T> tree, Integer key){
        return search(tree.dtm(), tree.root(), key);
    }
    
    private static <T> BinaryNode<T> search(DataTypeMethods<T> dtm, BinaryNode<T> root, Integer key){
        if ((root == null) || (dtm.isEqual(root.data(), key)))
            return root;        
        if(dtm.greaterThan(root.data(), key))
            return search(dtm, root.leftSon(), key);
        else
            return search(dtm, root.rightSon(), key);
    } 
    
    
    
//    public static <T> String inorderString(BSTree<T> tree){
//        
//    }
//    
//    
//    public static <T> String nodeToStringProcess(DataTypeMethods<T> dtm, BinaryNode<T> node){
//        return dtm.toString(node.data());
//    }
//    public static <T> void nodeToPrintProcess(DataTypeMethods<T> dtm, BinaryNode<T> node){
//        System.out.println( dtm.toString(node.data()));
//    }
//    
//    
//    private static <T> BinaryNode<T> processNode(DataTypeMethods<T> dtm, BinaryNode<T> nodeToProcess, String process){
//        
//        switch(process){
//            case "toString":
//                nodeToStringProcess(dtm, nodeToProcess);
//                return nodeToProcess;
//            case "toPrint":
//                nodeToPrintProcess(dtm, nodeToProcess);
//                return nodeToProcess;               
//        }       
//        return nodeToProcess;
//    }   
    
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
