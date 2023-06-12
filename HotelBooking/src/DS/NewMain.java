/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DS;

/**
 *
 * @author andre
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable hash = new HashTable(10);
        hash.insert("pablo",1 );
        hash.insert("pbloa",2 );
        hash.insert("olbap",3 );
        hash.insert("juan",4 );
        hash.insert("nuaj",5 );
        
        System.out.println(hash.searchByKey("olbap"));

    }
    
}
