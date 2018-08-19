/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.Booking;
import ClassFiles.DBConnect;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Vince Lance
 */
public class BookingInternalFrame extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String model2 = null;
    int row = -1;
    int bid;
    int cid;
    public BookingInternalFrame() {
        initComponents();
        con = DBConnect.connect();
        LoaddTable();
    }
    
    public void LoaddTable(){
    
        try {
            String sql = "select bid as Booking_ID,c.name as Customer_Name,b.customerId as Customer_ID,vt.typeName as Vehicle_Type, StartDate as Start_Date,endDate as End_Date,charge as Charge from booking b, customer c, vehicletype vt where b.vehicleId=0 AND vt.vtId=b.vtId AND b.customerId=c.customerId";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bookingpane = new javax.swing.JDesktopPane();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(968, 651));
        setMinimumSize(new java.awt.Dimension(968, 651));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(54, 21, 708, 311);

        jButton1.setText("Update Booking");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(803, 21, 121, 25);

        jButton2.setText("Delete Booking");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(803, 64, 117, 25);

        jButton3.setText("Rent Vehicle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(803, 107, 103, 25);

        bookingpane.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout bookingpaneLayout = new javax.swing.GroupLayout(bookingpane);
        bookingpane.setLayout(bookingpaneLayout);
        bookingpaneLayout.setHorizontalGroup(
            bookingpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        bookingpaneLayout.setVerticalGroup(
            bookingpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );

        getContentPane().add(bookingpane);
        bookingpane.setBounds(54, 350, 708, 255);

        jButton5.setText("Generate Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(803, 150, 127, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/968.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(968, 651));
        jLabel1.setMinimumSize(new java.awt.Dimension(968, 651));
        jLabel1.setPreferredSize(new java.awt.Dimension(968, 651));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1180, 650);

        setBounds(-5, -35, 1175, 685);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete The Selected Booking?");
        if(x==0)
            {    
            row = jTable1.getSelectedRow();
            if(row !=-1){
                Booking bk = new Booking(bid);
                try {
                    bk.DeleteBooking();
                    LoaddTable();
                } catch (SQLException ex) {
                    Logger.getLogger(BookingInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                row = -1;
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Select a Booking to Delete From the List");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        row = jTable1.getSelectedRow();
        bid = (int)jTable1.getValueAt(row, 0);
        cid = (int)jTable1.getValueAt(row, 2);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        row = jTable1.getSelectedRow();
        if(row !=-1){
            bookingpane.removeAll();
            RentInternalFrame rv = new RentInternalFrame(bid,this);
            bookingpane.add(rv).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a Booking to Rent From the List");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        row = jTable1.getSelectedRow();
        if(row !=-1){
            try {
                String type = jTable1.getValueAt(row, 3).toString();
                bookingpane.removeAll();
                CustomerUpdateBooking rv = new CustomerUpdateBooking(bid,cid,type,this);
                bookingpane.add(rv).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(BookingInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select a Booking to Rent From the List");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Compile jrxml file.
        JasperReport jasperReport;
        try {
            // Compile jrxml file.
            jasperReport = JasperCompileManager.compileReport("src/Reports/BookingsReport.jrxml");

            // Parameters for report
            Map<String, Object> parameters = new HashMap<String, Object>();

            // DataSource
            Connection conn = DBConnect.connect();
            // This is simple example, no database.
            // then using empty datasource.

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters,conn);

            // Make sure the output directory exists.
            File outDir = new File("src/jasperoutput");
            outDir.mkdirs();

            // Export to PDF.
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                "src/jasperoutput/BookingsReport.pdf");

            System.out.println("Done!");
        } catch (JRException ex) {
            Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        File file = new File("src/jasperoutput/BookingsReport.pdf");
        if(file.exists())
        {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane bookingpane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
