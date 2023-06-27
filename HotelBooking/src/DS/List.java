/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS;

import ImportantClasses.Person;
import Interfaces.LinkedList;

/**
 *
 * @author Andrea
 * @param <T>
 */
public class List<T> 
{
    private ListNode pFirst;
    private ListNode pLast;
    private int size;
    

    public List() {
        this.pFirst = this.pLast=null;
        this.size=0;
       // this.DTM = DTM;
    }

    public List(ListNode pFirst, ListNode pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
    }
    

    public boolean isEmpty() {
        return getpFirst() == null;
    }

    public ListNode addFirst(T data) {
        ListNode toAdd = new ListNode(data);
        if (getpFirst() == null) {
            setpFirst(toAdd);
            
        }else{
        toAdd.setpNext(getpFirst());
            setpFirst(toAdd);
        }
        setSize(getSize() + 1);
        return toAdd;
    }

    public ListNode addLast(T data) {
        ListNode toAdd = new ListNode(data);
         if (getpLast() == null) {
            setpLast( toAdd);
            
        }else{
            getpLast().setpNext(toAdd);
            setpFirst(pLast = toAdd);
        }
        setSize(getSize() + 1);
        return toAdd;
    }

    public ListNode Remove(ListNode toAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ListNode Search(ListNode toAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String printList(){
        
    ListNode <T> pAux;
    String resultado="";
        if (isEmpty()){
            resultado=" está vacía";

        }else{
            pAux=pFirst;
            while(pAux!= null){
                resultado=resultado + pAux.getData()+ ", ";
                pAux=pAux.getpNext();
                //pAux=pAux.pnext;
            }
        }
        return resultado;
 }
    
    public String printListPerson(List<Person> list){
        System.out.println(list.size);
        String resultado= "";
        resultado+="CLIENTS: \n\n";
    ListNode <Person> pAux;
    
        if (this.isEmpty()){
            resultado="There are no elements on the list";

        }else{
            
            pAux=list.getpFirst();
            while(pAux!= null){
                resultado+=  "ID: " + pAux.getData().id + "\nNAME: " + pAux.getData().firstName + " " + pAux.getData().lastName + "\nEMAIL: " + pAux.getData().email + "\nGENRE: " + pAux.getData().gender +  "\nARRIVAL: " + pAux.getData().arrival + "\n\n" ;
                pAux= pAux.getpNext();
                //pAux=pAux.pnext;
            }
        }
        return resultado;
 }

    /**
     * @return the pFirst
     */
    public ListNode getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(ListNode pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public ListNode getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(ListNode pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

//    /**
//     * @return the DTM
//     */
//    public LinkedList<T> getDTM() {
//        return DTM;
//    }
//
//    /**
//     * @param DTM the DTM to set
//     */
//    public void setDTM(LinkedList<T> DTM) {
//        this.DTM = DTM;
//    }
//        
    }

