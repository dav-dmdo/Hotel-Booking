/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantClasses.Client;
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
    /**
     * This method searches for a parent fit-able for the node to add following
     * the rules of the ABB.
     *
     * @param root
     * @param data
     * @return NodeABB
     */
    private NodeABB searchParent(NodeABB<T> root, T data) {
        NodeABB found = null;
        if (Integer.parseInt(data.toString()) < Integer.parseInt(root.getData().toString())) {
            return this.addedProccess(root, root.getLeft(), data);

        } else if (Integer.parseInt(data.toString()) > Integer.parseInt(root.getData().toString())) {
            return this.addedProccess(root, root.getRight(), data);
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
    private NodeABB addedProccess(NodeABB<T> father, NodeABB<T> son, T data) {
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
            NodeABB<T> nodeAux = this.searchParent(this.root, data);
            if (nodeAux == null) {
                JOptionPane.showMessageDialog(null, "repeated");
                //nodeAux.setCounter(nodeAux.getCounter() + 1);

            }else if (Integer.parseInt(nodeAux.getData().toString()) > Integer.parseInt(toAdd.getData().toString())) {
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
        String toPrint = this.preorder(this.root, "");
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
        output += root.getData() + "--> ";
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
        String toPrint = this.inorder(this.root, "");
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
        output += root.getData() + "--> ";
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
        String toPrint = this.postorder(this.root, "");
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
        output += root.getData() + "-->";
        return output;
    }
    
    
    public NodeABB SearchID(int valor, NodeABB<Client> root) {
        if (this.isEmpty()) {
            return null;

        } else {
            if (Integer.parseInt(root.toString()) == valor) {
                return root;

            } else {
                if (valor < Integer.parseInt(root.toString())) {
                    return SearchID(valor, root.getLeft());
                } else {
                    return SearchID(valor, root.getRight());
                }
            }
        }
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
