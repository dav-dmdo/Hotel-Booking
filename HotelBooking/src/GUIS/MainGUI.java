/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS;

import DS.BinarySearchTree;
import ImportantClasses.Booking;
import ImportantClasses.Historical;

/**
 *
 * @author Andrea
 */
public class MainGUI extends javax.swing.JFrame {
    static BinarySearchTree<Booking> bstBooking;
    static BinarySearchTree<Historical> bstHistory;

    /**
     * Creates new form MainGUI
     * @param bstBooking
     */
    public MainGUI(BinarySearchTree<Booking> bstBooking, BinarySearchTree<Historical> bstHistory) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.bstBooking = bstBooking;
        this.bstHistory = bstHistory;
        
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
        searchReservation = new javax.swing.JButton();
        searchRoomHistory = new javax.swing.JButton();
        CheckOut = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        CheckIn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        registerClient1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(137, 103, 103));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HOTEL-BOOKING");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        searchReservation.setBackground(java.awt.SystemColor.control);
        searchReservation.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchReservation.setForeground(new java.awt.Color(134, 102, 102));
        searchReservation.setText("Search Reservation");
        searchReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReservationActionPerformed(evt);
            }
        });
        jPanel1.add(searchReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        searchRoomHistory.setBackground(java.awt.SystemColor.control);
        searchRoomHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchRoomHistory.setForeground(new java.awt.Color(134, 102, 102));
        searchRoomHistory.setText("Search Room history");
        searchRoomHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomHistoryActionPerformed(evt);
            }
        });
        jPanel1.add(searchRoomHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        CheckOut.setBackground(java.awt.SystemColor.control);
        CheckOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CheckOut.setForeground(new java.awt.Color(134, 102, 102));
        CheckOut.setText("Check-Out");
        CheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutActionPerformed(evt);
            }
        });
        jPanel1.add(CheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(137, 102, 102));
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 50, 30));

        CheckIn.setBackground(java.awt.SystemColor.control);
        CheckIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CheckIn.setForeground(new java.awt.Color(134, 102, 102));
        CheckIn.setText("Check-In");
        CheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInActionPerformed(evt);
            }
        });
        jPanel1.add(CheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/building.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        registerClient1.setBackground(java.awt.SystemColor.control);
        registerClient1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registerClient1.setForeground(new java.awt.Color(134, 102, 102));
        registerClient1.setText("Register Client");
        registerClient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerClient1ActionPerformed(evt);
            }
        });
        jPanel1.add(registerClient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/heart.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.SystemColor.control);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(137, 104, 104));
        jTextArea1.setRows(5);
        jTextArea1.setText("WELCOME TO (HOTEL NAME)! here you have the\noptions to pick:\n\n1) Register a client: here you will be able to see \nwhereclients are staying in.\n2) Search reservation: here you will be able to see\nthe reservation details of a costumer.\n3) Search room history: here you will be able to\nsee all the people who previously stayed in that\nroom.\n4) Check-In:  Assign a room to a client.\n5) Check-Out: Closes client reservation.");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 310, 140));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/files.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/trash.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/searchicon.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReservationActionPerformed
        SearchReservationGUI searchReservation = new SearchReservationGUI(bstBooking);
        searchReservation.show();
    }//GEN-LAST:event_searchReservationActionPerformed

    private void searchRoomHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoomHistoryActionPerformed
        RoomHistory seeRoomHistory = new RoomHistory(bstHistory);
        seeRoomHistory.show();
    }//GEN-LAST:event_searchRoomHistoryActionPerformed

    private void CheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckOutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void CheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInActionPerformed

    private void registerClient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerClient1ActionPerformed

        RegisterClientGUI registerClientGUI = new RegisterClientGUI();
        registerClientGUI.show();

    }//GEN-LAST:event_registerClient1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI(bstBooking, bstHistory).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton registerClient1;
    private javax.swing.JButton searchReservation;
    private javax.swing.JButton searchRoomHistory;
    // End of variables declaration//GEN-END:variables
}
