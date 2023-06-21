/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantClasses.Booking;

import javax.swing.JOptionPane;

/**
 *
 * @author andrea
 * @param <T>
 */
public class BinarySearchTree<T> {

    private NodeABB<T> root;

    //Constructor
    public BinarySearchTree() {
        this.root = null;
    }
    //Primitives  
    public boolean isEmpty() {
        return root == null;
    }
    //Primitives ID
    /**
     * This method searches for a parent fit-able for the node to add following
     * the rules of the ABB in terms of client ID.
     *
     * @param root
     * @param booking
     * @return NodeABB
     */
    public NodeABB searchParentID(NodeABB<Booking> root, Booking booking) {
        NodeABB found = null;
        if (booking.id < root.getData().id) {
            return this.addedProccessID(root, root.getLeft(), booking);

        } else if (booking.id > root.getData().id) {
            return this.addedProccessID(root, root.getRight(), booking);
        }
        return found;
    }
    /**
     * Added method so you dont repeat the code, it searches the parent
     * depending on the parameter received.
     *
     * @param father
     * @param son
     * @param booking
     * @return
     */
    public NodeABB addedProccessID(NodeABB<Booking> father, NodeABB<Booking> son, Booking booking) {
        if (son != null) {
            return this.searchParentID(son, booking);

        } else {
            return father;
        }
    }
    /**
     * This inserts a new node into the tree.
     *
     * @param booking
     */
    public void insertID(Booking booking) {
        NodeABB<Booking> toAdd = new NodeABB(booking);
        if (this.isEmpty()) {
            this.root = (NodeABB<T>) ((T) toAdd);

        } else {
            NodeABB<Booking> nodeAux = this.searchParentID((NodeABB<Booking>) this.root, booking);
            if (nodeAux.getData().id == null) {
                JOptionPane.showMessageDialog(null, "Repeated ID, cannot add.");
                //nodeAux.setCounter(nodeAux.getCounter() + 1);

            } else if (nodeAux.getData().id > toAdd.getData().id) {
                nodeAux.setLeft(toAdd);

            } else {
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
        String toPrint = this.preorder((NodeABB<Booking>) this.root, "");
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
    private String preorder(NodeABB<Booking> root, String output) {
        output += root.getData().id + "--> ";
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
        String toPrint = this.inorder((NodeABB<Booking>) this.root, "");
        return toPrint + "//";
    }
    /**
     * This is the second part of the method, it will run the tree in inorder.
     *
     * @param root
     * @param output
     * @return
     */
    private String inorder(NodeABB<Booking> root, String output) {
        if (root.getLeft() != null) {
            output = inorder(root.getLeft(), output);

        }
        output += root.getData().id + "--> ";
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
        toPrint = this.postorder((NodeABB<Booking>) this.root, "");
        return toPrint + "//";
    }
    /**
     * This is the second part of the method, it will run the tree in post order
     *
     * @param root
     * @param output
     * @return
     */
    private String postorder(NodeABB<Booking> root, String output) {
        if (root.getLeft() != null) {
            output = postorder(root.getLeft(), output);

        }
        if (root.getRight() != null) {
            output = postorder(root.getRight(), output);

        }

        output += root.getData().id + "-->";
        return output;
    }
    /**
     * This method searches an ID number and returns the Node it belongs.
     *
     * @param valor
     * @param root
     * @return
     */
    public String SearchID(int valor, NodeABB<Booking> root) {
        String output = "";
        output = "CLIENT INFORMATION:\n";
        if (this.isEmpty()) {
            output = "This ID wasn't found.";
            return output;

        } else {

            if (root.getData().id == valor) {
                output += "ID: " + root.getData().id + "\nNAME: " + root.getData().firstName + " " + root.getData().lastName + "\nEMAIL: " + root.getData().email + "\nGENRE: " + root.getData().gender + "\nPHONE NUMBER: " + root.getData().phoneNumber + "\nARRIVAL: " + root.getData().arrivalDate + "\nDEPARTURE DATE: " + root.getData().departureDate + "\n\n";
                return output;

            } else {
                if (valor < root.getData().id) {
                    return SearchID(valor, root.getLeft());
                } else {
                    return SearchID(valor, root.getRight());
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
    public NodeABB deleteNode(NodeABB<Booking> root, int key) {
        if(root == null) return root;
        if(key > root.getData().id){ 
            root.setRight(deleteNode(root.getRight(), key));
        }else if(key < root.getData().id){ 
            root.setLeft(deleteNode(root.getLeft(), key));
        }else{ 
            if(root.getLeft() == null && root.getRight() == null){ 
                root = null;
            }else if(root.getRight() != null){ 
                root.setData(successor(root).getData()); // my worthy successor
                root.setRight(deleteNode(root.getRight(), root.getData().id));
            }else{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
                root.setData(predecessor(root).getData());
                root.setLeft(deleteNode(root.getLeft(), root.getData().id));
            }
        }
        return root;
    }
    /**
     * Return node's successor value
     * @param root
     * @return
     */
    private NodeABB<Booking> successor(NodeABB<Booking> root){
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
    private NodeABB<Booking> predecessor(NodeABB<Booking> root){
        root = root.getLeft();
        while(root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }


//Getters & Setters
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

}
