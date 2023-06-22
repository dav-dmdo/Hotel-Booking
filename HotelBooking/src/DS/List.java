/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DS;

import ImportantClasses.Client;
import Interfaces.LinkedList;

/**
 *
 * @author Andrea
 * @param <T>
 */
public class List<T> implements LinkedList{
    private ListNode pFirst;
    private ListNode pLast;
    private int size;
    private LinkedList<T> DTM;

    public List(LinkedList<T> DTM) {
        this.pFirst = this.pLast=null;
        this.size=0;
        this.DTM = DTM;
    }

    @Override
    public boolean isEmpty() {
        return pFirst == null;
    }

    @Override
    public ListNode addFirst(ListNode toAdd) {
        if (pLast == null) {
            pFirst = toAdd;
            
        }else{
        toAdd.setpNext(pFirst);
        pFirst = toAdd;
        }
        size++;
        return toAdd;
    }

    @Override
    public ListNode addLast(ListNode toAdd) {
         if (pLast == null) {
            pFirst = pLast = toAdd;
            
        }else{
        pLast.setpNext(toAdd);
        pLast = toAdd;
        }
        size++;
        return toAdd;
    }

    @Override
    public ListNode Remove(ListNode toAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListNode Search(ListNode toAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String printListPerson(List<Client> list){
    ListNode <Client> pAux;
    String resultado="";
        if (this.isEmpty()){
            resultado="There are no elements on the list";

        }else{
            pAux=pFirst;
            while(pAux!= null){
                resultado=resultado + pAux.getData().firstName+ ", ";
                pAux=próximo(pAux);
                //pAux=pAux.pnext;
            }
        }
        return resultado;
 }
        
    }
}
