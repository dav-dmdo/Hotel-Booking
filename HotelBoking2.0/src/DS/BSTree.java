/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DS;

import ImportantDataTypes.DataTypeMethods;
import Nodes.BinaryNode;

/**
 * 
 * @see BSTreeMethods.java
 * La clase BSTree representa un árbol binario de búsqueda genérico. Contiene
 * métodos para agregar, insertar y buscar elementos en el árbol.
 *
 * @param <T> tipo genérico de datos que se utilizará en el árbol.
 */
public class BSTree<T> {

    private BinaryNode<T> root;
    private DataTypeMethods<T> dtm;

    /**
     * Constructor que recibe un nodo raíz y un objeto DataTypeMethods.
     *
     * @param root nodo raíz del árbol.
     * @param dtm objeto DataTypeMethods utilizado para comparar los datos del
     * árbol.
     */
    public BSTree(BinaryNode<T> root, DataTypeMethods<T> dtm) {
        this.root = root;
        this.dtm = dtm;
    }

    /**
     * Constructor que recibe un objeto DataTypeMethods y crea un árbol vacío
     * sin nodo raíz.
     *
     * @param dtm objeto DataTypeMethods utilizado para comparar los datos del
     * árbol.
     */
    public BSTree(DataTypeMethods<T> dtm) {
        this.dtm = dtm;
        this.root = null;
    }

    /**
     * Método que verifica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false en caso contrario.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Método que agrega un nuevo elemento al árbol.
     *
     * @param data el elemento que se quiere agregar.
     */
    public void add(T data) {
        BinaryNode<T> newNode = new BinaryNode(data);

        if (isEmpty()) {
            root = newNode;
        } else {
            BinaryNode<T> father = searchParentForInsertion(this.root, data);
            if (father == null) {
                System.out.println("El elemento ya forma parte del árbol.");
            } else if (dtm.greaterThan(father.data(), data)) {
                father.leftSon(newNode);
            } else {
                father.rightSon(newNode);
            }

        }

    }

    /**
     * Método privado que busca el padre donde se debe insertar un nuevo
     * elemento.
     *
     * @param root el nodo raíz del subárbol donde se busca el padre.
     * @param data el elemento que se quiere agregar.
     * @return el nodo padre donde se debe insertar el nuevo elemento.
     */
    private BinaryNode<T> searchParentForInsertion(BinaryNode<T> root, T data) {
        BinaryNode<T> found = null;

        if (dtm.lessThan(data, root.data())) {
            return processNode(root, root.leftSon(), data);
        } else if (dtm.greaterThan(data, root.data())) {
            return processNode(root, root.rightSon(), data);
        }
        return found;
    }

    /**
     * Método privado que procesa cada nodo del subárbol para buscar el padre
     * donde se debe insertar un nuevo elemento.
     *
     * @param father el nodo padre actual.
     * @param son el nodo hijo actual.
     * @param data el elemento que se quiere agregar.
     * @return el nodo padre donde se debe insertar el nuevo elemento.
     */
    private BinaryNode<T> processNode(BinaryNode<T> father, BinaryNode<T> son, T data) {
        if (son != null) {
            return searchParentForInsertion(son, data);
        } else {
            return father;
        }
    }

    /**
     * Método que inserta un nuevo elemento al árbol.
     *
     * @param data el elemento que se quiere agregar.
     */
    public void insert(T data) {
        root = insert(this.root, data);
    }

    /**
     * Método privado que inserta un nuevo elemento al subárbol.
     *
     * @param root el nodo raíz del subárbol.
     * @param data el elemento que se quiere agregar.
     * @return el nodo raíz del subárbol actualizado.
     */
    private BinaryNode<T> insert(BinaryNode<T> root, T data) {
        if (root == null) {
            root = new BinaryNode<>(data);
            return root;
        }
        if (dtm.lessThan(data, root.data())) {
            root.leftSon(insert(root.leftSon(), data));
        } else {
            root.rightSon(insert(root.rightSon(), data));
        }
        return root;
    }

    /**
     * Método que busca un elemento en el árbol.
     *
     * @param data el elemento que se quiere buscar.
     * @return el nodo que contiene el elemento buscado, null si no se
     * encuentra.
     */
    public BinaryNode<T> search(T data) {
        return search(this.root, data);
    }

    /**
     * Método privado que busca unelemento en el subárbol.
     *
     * @param root el nodo raíz del subárbol.
     * @param data el elemento que se quiere buscar.
     * @return el nodo que contiene el elemento buscado, null si no se
     * encuentra.
     */
    private BinaryNode<T> search(BinaryNode<T> root, T data) {
        if ((root == null) || (dtm.isEqual(root.data(), data))) {
            return root;
        }
        if (dtm.lessThan(data, root.data())) {
            return search(root.leftSon(), data);
        } else {
            return search(root.rightSon(), data);
        }
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
