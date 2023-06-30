/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportantDataTypes;

import DS.HashTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 *
 */
public class Helpers {


/**
    /**
     * 
     *
     * @param numString
     * @return
 */
    public static int valorNumero(String numString) {
        int num;
        try {
            num = Integer.parseInt(numString);
            if (num > 0) {
                return num;

            } else {
                JOptionPane.showMessageDialog(null, "This isnt a valid number. ");
                return -1;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "This isnt a valid number. ");
            return -1;
        }

    }
    
    
}
