/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIS;

import ControllerAndRelated.Controller;

import DS.BSTree;
import ImportantDataTypes.Booking;
import ImportantDataTypes.Helpers;
import ImportantDataTypes.Room;
import Nodes.BinaryNode;
import javax.swing.JOptionPane;
import static ControllerAndRelated.BSTreeMethods.searchRoomByNumber;


/**
 *
 * @author Andrea
 */
public class RoomHistory extends javax.swing.JFrame {
    static Controller controller;
   

    /**
     * Creates new form RoomHistory
     */
    public RoomHistory(Controller controller) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.controller = controller;
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
        roomNumber = new javax.swing.JTextField();
        searchRoomHistory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        show = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(137, 103, 103));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SEARCH ROOM HISTORY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Please enter a room number to find the history of everyone who has stayed in the room");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        roomNumber.setBackground(java.awt.SystemColor.controlHighlight);
        roomNumber.setForeground(new java.awt.Color(137, 103, 103));
        roomNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberActionPerformed(evt);
            }
        });
        jPanel1.add(roomNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, -1));

        searchRoomHistory.setBackground(java.awt.SystemColor.controlHighlight);
        searchRoomHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchRoomHistory.setForeground(new java.awt.Color(137, 103, 103));
        searchRoomHistory.setText("Search");
        searchRoomHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomHistoryActionPerformed(evt);
            }
        });
        jPanel1.add(searchRoomHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 120, -1));

        show.setEditable(false);
        show.setBackground(new java.awt.Color(255, 255, 255));
        show.setColumns(20);
        show.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        show.setForeground(new java.awt.Color(137, 103, 103));
        show.setRows(5);
        show.setText("\n");
        jScrollPane1.setViewportView(show);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 320, 240));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIS/Pictures/diskplayer.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(137, 103, 103));
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchRoomHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchRoomHistoryActionPerformed
        try {

            String ID_String = roomNumber.getText();
            int ID = Helpers.valorNumero(ID_String);
            if (ID !=-1) {
                

                String roomInfo = controller.getRoomRecord(ID);
                if (roomInfo == "") {
                    show.setText("This room doesnt exist");
                    
                }
                else
                System.out.println(roomInfo);
                show.setText("ROOM "+ID+" \n\n"+ roomInfo);
                //showInfo.setText(NodeSearch);
                roomNumber.setText("");
                

            }
        } catch (NullPointerException e) {
            show.setText(roomNumber.getText() + " doesn't have a reservation.");
            roomNumber.setText("");
        }
    }//GEN-LAST:event_searchRoomHistoryActionPerformed

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
            java.util.logging.Logger.getLogger(RoomHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomHistory(controller).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField roomNumber;
    private javax.swing.JButton searchRoomHistory;
    private javax.swing.JTextArea show;
    // End of variables declaration//GEN-END:variables
}