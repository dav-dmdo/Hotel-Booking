/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS;

import DS.BinarySearchTree;
import DS.NodeABB;
import ImportantClasses.Booking;
import ImportantClasses.Helpers;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class SearchReservationGUI extends javax.swing.JFrame {
    static BinarySearchTree<Booking> bstBooking = new BinarySearchTree();
    

    /**
     * Creates new form SearchReservationGUI
     * @param bstBooking
     */
    public SearchReservationGUI(BinarySearchTree<Booking> bstBooking) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.bstBooking = bstBooking;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clientID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        showInfo = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        searchReservation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(137, 103, 103));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SEARCH RESERVATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/CALENDAR.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Please enter an ID to know its owner's reservation details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        clientID.setBackground(java.awt.SystemColor.controlHighlight);
        clientID.setForeground(new java.awt.Color(137, 103, 103));
        jPanel1.add(clientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, -1));

        showInfo.setEditable(false);
        showInfo.setBackground(java.awt.SystemColor.controlHighlight);
        showInfo.setColumns(20);
        showInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showInfo.setForeground(new java.awt.Color(137, 103, 103));
        showInfo.setRows(5);
        jScrollPane1.setViewportView(showInfo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/FLOWERS.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        jButton1.setBackground(java.awt.SystemColor.controlHighlight);
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(137, 103, 103));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        searchReservation.setBackground(new java.awt.Color(255, 255, 255));
        searchReservation.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchReservation.setForeground(new java.awt.Color(137, 103, 103));
        searchReservation.setText("Search");
        searchReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReservationActionPerformed(evt);
            }
        });
        jPanel1.add(searchReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReservationActionPerformed
          try {

            String ID_String = clientID.getText();
            int ID = Helpers.valorNumero(ID_String);
            if (ID == -1) {

            } else {
                String NodeSearch = bstBooking.printIDSearch(bstBooking.SearchID(ID, bstBooking.getRoot()));

                showInfo.setText(NodeSearch);
                clientID.setText("");

            }
        } catch (NullPointerException e) {
            showInfo.setText(clientID.getText() + " doesn't have a reservation.");
            clientID.setText("");
        }

    }//GEN-LAST:event_searchReservationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchReservationGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchReservationGUI(bstBooking).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchReservation;
    private javax.swing.JTextArea showInfo;
    // End of variables declaration//GEN-END:variables
}
