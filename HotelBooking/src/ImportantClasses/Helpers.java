/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImportantClasses;

import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 *
 */
public class Helpers {
     /**
     * This method checks if the parameter sent is a int.
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
