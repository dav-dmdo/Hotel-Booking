/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import Interfaces.DataTypeMethods;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 * @param <T>
 */
public class BSTree <T> {
    private NodeABB<T> root;
    private DataTypeMethods<T> dtm;
    
    public BSTree(DataTypeMethods <T> dtm){
        root = null;
        this.dtm = dtm;
    }
    
    //Primitives
     public boolean isEmpty() {
        return getRoot() == null;
    }
     
     /**
     * This method searches for a parent fit-able for the node to add following
     * the rules of the ABB..
     *
     * @param root
     * @param data
     * @return NodeABB
     */
    public NodeABB searchParent(NodeABB<T> root, int data) {
        NodeABB found = null;
        if (dtm.lessThan(data, ((T) root))) {
            return this.addedProccessID(root, root.getLeft(), data);
            
        }
        else if(dtm.greaterThan(data, (T) root)){
            return this.addedProccessID(root, root.getRight(), data);
        }
        return found;
    }
    
    /**
     * Added method so you dont repeat the code, it searches the parent
     * depending on the parameter received.
     *
     * @param father
     * @param son
     * @param data
     * @return
     */
    public NodeABB addedProccessID(NodeABB<T> father, NodeABB<T> son, int data) {
        if (son != null) {
            return this.searchParent(son, data);

        } else {
            return father;
        }
    }
    /**
     * This inserts a new node into the tree.
     *
     * @param data
     */
    public void insert(T data) {
        NodeABB<T> toAdd = new NodeABB(data);
        if (this.isEmpty()) {
            this.root = toAdd;

        } else {
            NodeABB<T> nodeAux = this.searchParent(this.root, dtm.getKey(data));
            if (dtm.getKey(nodeAux.getData())== null) {
                JOptionPane.showMessageDialog(null, "Repeated, cannot add.");
                //nodeAux.setCounter(nodeAux.getCounter() + 1);

            }else if (dtm.greaterThan(dtm.getKey((T) nodeAux), (T) toAdd)) {
                nodeAux.setLeft(toAdd); 
            }
            else {
                nodeAux.setRight(toAdd);
            }
        }
    }
    /**
     * This method is a two segment method we will access with this one, the
     * first one calls the actual method.
     *
     * @return String
     */
    public String preorder() {
        String toPrint = this.preorder((NodeABB<T>) this.root, "");
        return toPrint + "//";
    }
    /**
     * This is the second segment method, this one runs the binary search tree
     * in pre-order.
     *
     * @param root
     * @param output
     * @return
     */
    private String preorder(NodeABB<T> root, String output) {
        output += dtm.toString(root.getData()) + "--> ";
        if (root.getLeft() != null) {
            output = preorder(root.getLeft(), output);

        }
        if (root.getRight() != null) {
            output = preorder(root.getRight(), output);

        }
        return output;

    }
    /**
     * This is the method we will have access to, it will call the recursive
     * option to run in inorder
     *
     * @return String output
     */
    public String inorder() {
        String toPrint = this.inorder((NodeABB<T>) this.root, "");
        return toPrint + "//";
    }
    /**
     * This is the second part of the method, it will run the tree in inorder.
     *
     * @param root
     * @param output
     * @return
     */
    private String inorder(NodeABB<T> root, String output) {
        if (root.getLeft() != null) {
            output = inorder(root.getLeft(), output);

        }
        output += dtm.toString(root.getData()) + "--> ";
        if (root.getRight() != null) {
            output = inorder(root.getRight(), output);

        }

        return output;
    }
    /**
     * This is the public method we will call to run the post order print.
     *
     * @return String output
     */
    public String postorder() {
        String toPrint;
        toPrint = this.postorder((NodeABB<T>) this.root, "");
        return toPrint + "//";
    }
    /**
     * This is the second part of the method, it will run the tree in post order
     *
     * @param root
     * @param output
     * @return
     */
    private String postorder(NodeABB<T> root, String output) {
        if (root.getLeft() != null) {
            output = postorder(root.getLeft(), output);

        }
        if (root.getRight() != null) {
            output = postorder(root.getRight(), output);

        }

        output += dtm.toString(root.getData()) + "-->";
        return output;
    }
    /**
     * This method searches an ID number and returns the Node it belongs.
     *
     * @param valor
     * @param root
     * @return
     */
    public String Search(int valor, NodeABB<T> root) {
        String output;
        output = "INFORMATION:\n";
        if (this.isEmpty()) {
            output = "This wasn't found.";
            return output;

        } else {

            if (dtm.getKey((T) root)== valor) {
                output += dtm.toString(root.getData());
                return output;

            } else {
                if (valor < dtm.getKey((T) root)) {
                    return Search(valor, root.getLeft());
                } else {
                    return Search(valor, root.getRight());
                }
            }
        }
    }
/**
 * This deletes an element from the tree.
 * @param root
 * @param key
 * @return 
 */
    public NodeABB deleteNode(NodeABB<T> root, int key) {
        if(root == null) return root;
        if(key > dtm.getKey((T) root)){ 
            root.setRight(deleteNode(root.getRight(), key));
        }else if(key < dtm.getKey((T) root)){ 
            root.setLeft(deleteNode(root.getLeft(), key));
        }else{ 
            if(root.getLeft() == null && root.getRight() == null){ 
                root = null;
            }else if(root.getRight() != null){ 
                root.setData(successor(root).getData()); 
                root.setRight(deleteNode(root.getRight(), dtm.getKey((T) root)));
            }else{
                root.setData(predecessor(root).getData());
                root.setLeft(deleteNode(root.getLeft(), dtm.getKey((T) root)));
            }
        }
        return root;
    }
    /**
     * Return node's successor value
     * @param root
     * @return
     */
    private NodeABB<T> successor(NodeABB<T> root){
        root = root.getRight();
        while(root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }
    /**
     * Return node's predecessor value
     * @param root
     * @return
     */
    private NodeABB<T> predecessor(NodeABB<T> root){
        root = root.getLeft();
        while(root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }


    /**
     * @return the root
     */
    public NodeABB<T> getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(NodeABB<T> root) {
        this.root = root;
    }

    /**
     * @return the dtm
     */
    public DataTypeMethods<T> getDtm() {
        return dtm;
    }

    /**
     * @param dtm the dtm to set
     */
    public void setDtm(DataTypeMethods<T> dtm) {
        this.dtm = dtm;
    }
    
    
    
    
}
