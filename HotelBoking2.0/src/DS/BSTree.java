/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.BinaryNode;
/**
 * La clase BSTree implementa un árbol binario de búsqueda.
 * @param <T> tipo de datos genérico.
 */
public class BSTree<T> {
    private BinaryNode<T> root;
    private DataTypeMethods<T> dtm;

    /**
     * Constructor que recibe un nodo raíz y un objeto DataTypeMethods.
     * @param root nodo raíz del árbol binario.
     * @param dtm objeto DataTypeMethods que define los métodos para comparar y operar los datos del árbol.
     */
    public BSTree(BinaryNode<T> root, DataTypeMethods<T> dtm) {
        this.root = root;
        this.dtm = dtm;
    }

    /**
     * Constructor que recibe un objeto DataTypeMethods y crea un árbol binario vacío.
     * @param dtm objeto DataTypeMethods que define los métodos para comparar y operar los datos del árbol.
     */
    public BSTree(DataTypeMethods<T> dtm) {
        this.dtm = dtm;
        this.root = null;
    }
    
    /**
     * Verifica si el árbol binario está vacío.
     * @return true si el árbol está vacío, false en caso contrario.
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    /**
     * Agrega un elemento al árbol binario.
     * @param data elemento a agregar.
     */
    public void add(T data){
        BinaryNode<T> newNode = new BinaryNode(data);
        
        if (isEmpty()){
            root = newNode;
        }else{
            BinaryNode<T> father = searchParentForInsertion(this.root, data);
            if (father == null){
                System.out.println("El elemento ya es parte del árbol.");
            }else if(dtm.greaterThan(father.data(), data)){
                father.leftSon(newNode);
            }else{
                father.rightSon(newNode);
            }
            
        }
                    
    }
    
    /**
     * Busca el padre del nodo donde se insertará un elemento.
     * @param root nodo raíz del subárbol que se está explorando.
     * @param data elemento a insertar.
     * @return el padre del nodo donde se insertará el elemento, o null si el elemento ya existe en el árbol.
     */
    private BinaryNode<T> searchParentForInsertion(BinaryNode<T> root, T data){
        BinaryNode<T> found = null;
        
        if (dtm.lessThan(data, root.data())){
            return processNode(root, root.leftSon(), data);            
        }else if(dtm.greaterThan(data, root.data())){
            return processNode(root, root.rightSon(), data);
        }
        return found;
    }
    
    /**
     * Procesa un nodo en la búsqueda del padre del nodo donde se insertará un elemento.
     * @param father nodo padre del nodo actual que se está procesando.
     * @param son nodo hijo que se está explorando.
     * @param data elemento a insertar.
     * @return el padre del nodo donde se insertará el elemento, o el último nodo explorado si el elemento ya existe en el árbol.
     */
    private BinaryNode<T> processNode(BinaryNode<T> father, BinaryNode<T> son, T data){
        if (son != null){
            return searchParentForInsertion(son, data);
        } else {
            return father;
        }
    }
    
    /**
     * Inserta un elemento en el árbol binario.
     * @param data elemento a insertar.
     */
    public void insert(T data){
        root = insert(this.root, data);       
    }
    
    /**
     * Inserta un elemento en el subárbol cuyo nodo raíz es el especificado.
     * @param root nodo raíz del subárbol donde se insertará el elemento.
     * @param data elemento a insertar.
     * @return el nodo raíz del subárbol actualizado.
     */
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
    
    /**
     * Busca un elemento en el árbol binario.
     * @param data elemento a buscar.
     * @return el nodo que contiene el elemento, o null si el elemento no está en el árbol.
     */
    public BinaryNode<T> search(T data){
        return search(this.root, data);
    }
/**
 * Busca un elemento en el subárbol cuyo nodo raíz es el especificado.
 * @param root nodo raíz del subárbol donde se buscará el elemento.
 * @param data elemento a buscar.
 * @return el nodo que contiene el elemento, o null si el elemento no está en el subárbol.
 */
    private BinaryNode<T> search(BinaryNode<T> root, T data){
        if ((root == null) || (dtm.isEqual(root.data(), data)))
            return root;        
        if(dtm.lessThan(data, root.data()))
            return search(root.leftSon(), data);
        else
            return search(root.rightSon(), data);
    }    
    
    /**
     * Devuelve el nodo raíz del árbol binario.
     * @return el nodo raíz del árbol binario.
     */
    public BinaryNode<T> root() {
        return root;
    }

    /**
     * Establece el nodo raíz del árbol binario.
     * @param root el nodo raíz a establecer.
     */
    public void root(BinaryNode<T> root) {
        this.root = root;
    }

    /**
     * Devuelve el objeto DataTypeMethods utilizado por el árbol binario.
     * @return el objeto DataTypeMethods utilizado por el árbol binario.
     */
    public DataTypeMethods<T> dtm() {
        return dtm;
    }
}