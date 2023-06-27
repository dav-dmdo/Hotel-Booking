/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import Interfaces.DataTypeMethods;

/**
 *
 * @author david
 */
public class BSTree <T> {
    private NodeABB<T> root;
    private final DataTypeMethods<T> dtm;
    
    public BSTree(DataTypeMethods <T> dtm){
        root = null;
        this.dtm = dtm;
    }
    
    public void search(T data){
        NodeABB<T> aux= root;
        while(aux != null){
            boolean found = dtm.isEqual(aux.getData(), data);
        }
    }
    
    
}
