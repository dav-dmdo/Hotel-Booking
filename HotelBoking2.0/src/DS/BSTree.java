/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.BinaryNode;

/**
 *
 * @author david
 * 
 */
public class BSTree<T> {
    private BinaryNode<T> root;
    private DataTypeMethods<T> dtm;

    public BSTree(BinaryNode<T> root, DataTypeMethods<T> dtm) {
        this.root = root;
        this.dtm = dtm;
    }

    public BSTree(DataTypeMethods<T> dtm) {
        this.dtm = dtm;
        this.root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void add(T data){
        BinaryNode<T> newNode = new BinaryNode(data);
        
        if (isEmpty()){
            root = newNode;
        }else{
            BinaryNode<T> father = searchParentForInsertion(this.root, data);
            if (father == null){
                System.out.println("The element is already parte of the tree.");
            }else if(dtm.greaterThan(father.data(), data)){
                father.leftSon(newNode);
            }else{
                father.rightSon(newNode);
            }
            
        }
                    
    }
    
    private BinaryNode<T> searchParentForInsertion(BinaryNode<T> root, T data){
        BinaryNode<T> found = null;
        
        if (dtm.lessThan(data, root.data())){
            return processNode(root, root.leftSon(), data);            
        }else if(dtm.greaterThan(data, root.data())){
            return processNode(root, root.rightSon(), data);
        }
        return found;
    }
    
    private BinaryNode<T> processNode(BinaryNode<T> father, BinaryNode<T> son, T data){
        if (son != null){
            return searchParentForInsertion(son, data);
        } else {
            return father;
        }
    }
    
    
    public void insert(T data){
        root = insert(this.root, data);       
    }
    
    private BinaryNode<T> insert(BinaryNode<T> root, T data){
        if(root == null){
            root = new BinaryNode<> (data);
            return root;            
        }
        if(dtm.lessThan(data, root.data())){
            root.leftSon(insert(root.leftSon(), data));
        }else{
            root.rightSon(insert(root.rightSon(), data));
        }
        return root;
    }
    
    public BinaryNode<T> search(T data){
        return search(this.root, data);
    }
    
    private BinaryNode<T> search(BinaryNode<T> root, T data){
        if ((root == null) || (dtm.isEqual(root.data(), data)))
            return root;        
        if(dtm.lessThan(data, root.data()))
            return search(root.leftSon(), data);
        else
            return search(root.rightSon(), data);
    }    
    
    /**
     * @return the root
     */
    public BinaryNode<T> root() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void root(BinaryNode<T> root) {
        this.root = root;
    }

    /**
     * @return the dtm
     */
    public DataTypeMethods<T> dtm() {
        return dtm;
    }
    
    
    
    
    
}
