/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DS.ListNode;

/**
 *
 * @author Andrea
 * @param <T>
 */
public interface LinkedList<T>{
   public boolean isEmpty();
    public ListNode<T> addFirst(ListNode<T> toAdd);
    public ListNode<T> addLast(ListNode<T> toAdd);
    public ListNode<T> Remove(ListNode<T> toAdd);
    public ListNode<T> Search(ListNode<T> toAdd);
    
}
